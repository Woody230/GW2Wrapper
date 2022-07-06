package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.constant.Endpoints
import com.bselzer.gw2.v2.model.continent.Continent
import com.bselzer.gw2.v2.model.continent.ContinentId
import com.bselzer.gw2.v2.model.continent.floor.Floor
import com.bselzer.gw2.v2.model.continent.floor.FloorId
import com.bselzer.gw2.v2.model.tile.position.GridPosition
import com.bselzer.gw2.v2.model.tile.request.TileGridRequest
import com.bselzer.gw2.v2.model.tile.request.TileRequest
import com.bselzer.gw2.v2.model.tile.response.Tile
import com.bselzer.gw2.v2.model.tile.response.TileGrid
import com.bselzer.ktx.geometry.dimension.bi.Dimension2D
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
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
    private val baseUrls: MutableList<String> = configuration.baseUrls.toMutableList()

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
    suspend fun grid(continent: Continent, floor: Floor, zoom: Int): TileGrid {
        val request = requestGrid(continent, floor, zoom)
        return grid(request)
    }

    /**
     * @return the tile grid generated from the [request]
     * @param request the request to get the grid and tile content from
     */
    suspend fun grid(request: TileGridRequest): TileGrid {
        val tiles = tilesAsync(request.tileRequests).map { deferred -> deferred.await() }
        return TileGrid(request, tiles)
    }

    /**
     * @return the tile from the [TileRequest.url]
     * @param request the request to get the tile content from
     */
    suspend fun tile(request: TileRequest): Tile {
        val content: ByteArray = try {
            httpClient.get(request.url).body()
        } catch (ex: Exception) {
            ByteArray(0)
        }

        return Tile(request, content)
    }

    /**
     * @return the deferred tiles from the [TileRequest.url]
     * @param requests the requests to get the tile content from
     */
    suspend fun tilesAsync(requests: Collection<TileRequest>): Collection<Deferred<Tile>> = coroutineScope {
        // Use async for parallelism.
        requests.map { request ->
            async { tile(request) }
        }
    }

    /**
     * @return the requests for tiles on the [floor] within the [continent] at the given [zoom] level
     * @param continent the continent
     * @param floor the floor within the [continent]
     * @param zoom the level of detail between the [Continent.minZoom] and [Continent.maxZoom] inclusive
     */
    fun requestGrid(continent: Continent, floor: Floor, zoom: Int): TileGridRequest {
        // Default to the min/max zoom if the requested zoom is too little/much.
        val requestedZoom = max(0, min(zoom, continent.maxZoom))
        val requestedZoomTiles = 2.0.pow(requestedZoom)
        val maxZoomTiles = 2.0.pow(continent.maxZoom)

        // Get the dimensions of each individual tile.
        val textureDimensions = floor.textureDimensions
        val textureWidth = textureDimensions.width
        val textureHeight = textureDimensions.height
        val tileWidth = textureWidth / maxZoomTiles
        val tileHeight = textureHeight / maxZoomTiles

        // Get the tile position bounds within the grid.
        val clampedView = floor.clampedView
        val startX = floor(clampedView.topLeft.x * requestedZoomTiles / textureWidth).toInt()
        val endX = floor(clampedView.bottomRight.x * requestedZoomTiles / textureWidth).toInt()
        val startY = floor(clampedView.topLeft.y * requestedZoomTiles / textureHeight).toInt()
        val endY = floor(clampedView.bottomRight.y * requestedZoomTiles / textureHeight).toInt()

        // Create the requests for tile content.
        val requests = mutableListOf<TileRequest>()
        for (gridY in startY..endY) {
            for (gridX in startX..endX) {
                val url = baseUrls.random().constructUrl(continent.id, floor.id, requestedZoom, gridX, gridY)
                requests += TileRequest(
                    url = url,
                    gridPosition = GridPosition(x = gridX, y = gridY),
                    size = Dimension2D(width = tileWidth, height = tileHeight),
                    zoom = zoom
                )
            }
        }

        return TileGridRequest(
            tileSize = Dimension2D(width = tileWidth, height = tileHeight),
            textureSize = Dimension2D(width = textureWidth, height = textureHeight),
            topLeft = GridPosition(x = startX, y = startY),
            bottomRight = GridPosition(x = endX, y = endY),
            zoom = zoom,
            tileRequests = requests
        )
    }

    /**
     * @return the tile url
     */
    private fun String.constructUrl(continentId: ContinentId, floorId: FloorId, zoom: Int, x: Int, y: Int) = "$this/${continentId.value}/${floorId.value}/$zoom/$x/$y.jpg"

    /**
     * Close the HTTP client.
     */
    override fun close() {
        httpClient.close()
    }
}