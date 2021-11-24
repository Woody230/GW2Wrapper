package com.bselzer.library.gw2.v2.tile.client

import com.bselzer.library.gw2.v2.model.continent.Continent
import com.bselzer.library.gw2.v2.model.continent.ContinentFloor
import com.bselzer.library.gw2.v2.model.extension.continent.clampedView
import com.bselzer.library.gw2.v2.model.extension.continent.textureDimensions
import com.bselzer.library.gw2.v2.tile.constant.Endpoints
import com.bselzer.library.gw2.v2.tile.model.request.TileGridRequest
import com.bselzer.library.gw2.v2.tile.model.request.TileRequest
import com.bselzer.library.gw2.v2.tile.model.response.Tile
import com.bselzer.library.gw2.v2.tile.model.response.TileGrid
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.cio.*
import io.ktor.util.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.math.floor
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

open class TileClient(
    private val httpClient: HttpClient = HttpClient(),
    configuration: TileClientConfiguration = TileClientConfiguration()
) : Closeable {

    /**
     * The urls.
     */
    private val baseUrls: ArrayDeque<String> = ArrayDeque(configuration.baseUrls)

    init {
        // Default to the main url if no urls are provided.
        if (baseUrls.isEmpty()) {
            baseUrls.add(Endpoints.BASE_URL)
        }
    }

    /**
     * @return the tile grid for the [floor] within the [continent] at the given [zoom] level
     * @param continent the continent
     * @param floor the floor within the [continent]
     * @param zoom the level of detail between the [Continent.minZoom] and [Continent.maxZoom] inclusive
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki for continents</a>
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps"> the wiki for maps</a>
     */
    suspend fun grid(continent: Continent, floor: ContinentFloor, zoom: Int): TileGrid = grid(requestGrid(continent, floor, zoom))

    /**
     * @return the tile grid generated from the [request]
     * @param request the request to get the grid and tile content from
     */
    suspend fun grid(request: TileGridRequest): TileGrid {
        val tiles = request.tileRequests.map { tileRequest -> tileAsync(tileRequest) }.map { deferred -> deferred.await() }
        return TileGrid(request, tiles)
    }

    /**
     * @return the deferred tile from the [TileRequest.url]
     * @param request the request to get the tile content from
     */
    suspend fun tileAsync(request: TileRequest): Deferred<Tile> = coroutineScope {
        // Use async for parallelism.
        async {
            val content: ByteArray = try {
                httpClient.get(request.url)
            } catch (ex: Exception) {
                ByteArray(0)
            }
            return@async Tile(request, content)
        }
    }

    /**
     * @return the tile from the [TileRequest.url]
     * @param request the request to get the tile content from
     */
    suspend fun tile(request: TileRequest) = tileAsync(request).await()

    /**
     * @return the requests for tiles on the [floor] within the [continent] at the given [zoom] level
     * @param continent the continent
     * @param floor the floor within the [continent]
     * @param zoom the level of detail between the [Continent.minZoom] and [Continent.maxZoom] inclusive
     */
    suspend fun requestGrid(continent: Continent, floor: ContinentFloor, zoom: Int): TileGridRequest {
        // Default to the min/max zoom if the requested zoom is too little/much.
        val requestedZoom = max(0, min(zoom, continent.maxZoom))
        val requestedZoomTiles = 2.0.pow(requestedZoom)
        val maxZoomTiles = 2.0.pow(continent.maxZoom)

        // Get the dimensions of each individual tile.
        val textureDimensions = floor.textureDimensions()
        val textureWidth = textureDimensions.width.toInt()
        val textureHeight = textureDimensions.height.toInt()
        val tileWidth = (textureWidth / maxZoomTiles).toInt()
        val tileHeight = (textureHeight / maxZoomTiles).toInt()

        // Get the tile position bounds within the grid.
        val clampedView = floor.clampedView()
        val startX = floor(clampedView.point1.x * requestedZoomTiles / textureWidth).toInt()
        val endX = floor(clampedView.point2.x * requestedZoomTiles / textureWidth).toInt()
        val startY = floor(clampedView.point1.y * requestedZoomTiles / textureHeight).toInt()
        val endY = floor(clampedView.point2.x * requestedZoomTiles / textureHeight).toInt()

        // Create the requests for tile content.
        val requests = mutableListOf<TileRequest>()
        val mutex = Mutex()
        for (gridY in startY..endY) {
            for (gridX in startX..endX) {
                val url = takeBaseUrl(mutex).constructUrl(continent.id, floor.id, requestedZoom, gridX, gridY)
                requests.add(TileRequest(url = url, gridX = gridX, gridY = gridY, width = tileWidth, height = tileHeight, zoom = zoom))
            }
        }

        return TileGridRequest(
            startX = startX,
            endX = endX,
            startY = startY,
            endY = endY,
            tileWidth = tileWidth,
            tileHeight = tileHeight,
            textureWidth = textureWidth,
            textureHeight = textureHeight,
            zoom = zoom,
            tileRequests = requests
        )
    }

    /**
     * @return the first base url from [baseUrls].
     */
    // Cannot let multiple threads mess with the urls at the same time.
    private suspend fun takeBaseUrl(mutex: Mutex): String = mutex.withLock {
        // Distribute requests by cycling through the urls by taking one and returning it to the end of the queue.
        val url = baseUrls.removeFirst()
        baseUrls.addLast(url)
        return url
    }

    /**
     * @return the tile url
     */
    private fun String.constructUrl(continentId: Int, floorId: Int, zoom: Int, x: Int, y: Int) = "$this/$continentId/$floorId/$zoom/$x/$y.jpg"

    /**
     * Close the HTTP client.
     */
    override fun close() {
        httpClient.close()
    }
}