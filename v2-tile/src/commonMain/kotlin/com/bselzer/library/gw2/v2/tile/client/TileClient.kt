package com.bselzer.library.gw2.v2.tile.client

import com.bselzer.library.gw2.v2.model.continent.Continent
import com.bselzer.library.gw2.v2.model.continent.ContinentFloor
import com.bselzer.library.gw2.v2.tile.constants.Endpoints
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
     * @param request the request to get grid and tile content from
     */
    suspend fun grid(request: TileGridRequest): TileGrid = coroutineScope {
        val tiles = request.tileRequests.map { request -> tile(request) }
        return@coroutineScope TileGrid(request, tiles)
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
        val gridWidth = floor.textureDimensions.width
        val gridHeight = floor.textureDimensions.height
        val tileWidth = (gridWidth / maxZoomTiles).toInt()
        val tileHeight = (gridHeight / maxZoomTiles).toInt()

        // Get the tile position bounds within the grid.
        val startX = floor(floor.clampedView.point1.x * requestedZoomTiles / gridWidth).toInt()
        val endX = floor(floor.clampedView.point2.x * requestedZoomTiles / gridWidth).toInt()
        val startY = floor(floor.clampedView.point1.y * requestedZoomTiles / gridHeight).toInt()
        val endY = floor(floor.clampedView.point2.x * requestedZoomTiles / gridHeight).toInt()

        // Create the requests for tile content.
        val requests = mutableListOf<TileRequest>()
        val mutex = Mutex()
        for (y in startY..endY) {
            for (x in startX..endX) {
                val url = takeBaseUrl(mutex).constructUrl(continent.id, floor.id, requestedZoom, x, y)
                requests.add(TileRequest(url, x, y))
            }
        }

        return TileGridRequest(startX, endX, startY, endY, tileWidth, tileHeight, requests)
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