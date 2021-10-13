package com.bselzer.library.gw2.v2.tile.client

import com.bselzer.library.gw2.v2.model.continent.Continent
import com.bselzer.library.gw2.v2.model.continent.ContinentFloor
import com.bselzer.library.gw2.v2.tile.constants.Endpoints
import com.bselzer.library.gw2.v2.tile.model.Tile
import com.bselzer.library.gw2.v2.tile.model.TileGrid
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.cio.*
import io.ktor.util.*
import io.ktor.utils.io.core.*
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.math.floor
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
        if (baseUrls.isEmpty()) {
            baseUrls.add(Endpoints.BASE_URL)
        }
    }

    /**
     * @return the tile grid for the [floor] within the [continent] at the given [zoom] level
     */
    suspend fun grid(continent: Continent, floor: ContinentFloor, zoom: Int): TileGrid = coroutineScope {
        // Default to the max zoom if the requested zoom is too much.
        val requestedZoom = min(zoom, continent.maxZoom)
        val requestedZoomTiles = 2.0.pow(requestedZoom)
        val maxZoomTiles = 2.0.pow(continent.maxZoom)

        // Get the dimensions of each individual tile.
        val gridWidth = floor.textureDimensions.width
        val gridHeight = floor.textureDimensions.height
        val tileWidth = gridWidth / maxZoomTiles
        val tileHeight = gridHeight / maxZoomTiles

        // Get the tile position bounds within the grid.
        val minX = floor(floor.clampedView.x1 * requestedZoomTiles / gridWidth).toInt()
        val maxX = floor(floor.clampedView.x2 * requestedZoomTiles / gridWidth).toInt()
        val minY = floor(floor.clampedView.y1 * requestedZoomTiles / gridHeight).toInt()
        val maxY = floor(floor.clampedView.y2 * requestedZoomTiles / gridHeight).toInt()

        // Make the requests to get tile content.
        val deferred = mutableListOf<Deferred<Tile>>()
        val mutex = Mutex()
        for (y in minY..maxY) {
            for (x in minX..maxX) {
                val url = takeBaseUrl(mutex).constructUrl(continent.id, floor.id, requestedZoom, x, y)

                // Using async for parallelism.
                deferred.add(async {
                    try {
                        val content = httpClient.get<ByteArray>(url)
                        return@async Tile(x, y, content)
                    } catch (ex: Exception) {
                        return@async Tile(x, y, ByteArray(0))
                    }
                })
            }
        }

        val tiles = deferred.map { it.await() }.groupBy { it.y }.map { it.value }
        return@coroutineScope TileGrid(tileWidth.toInt(), tileHeight.toInt(), tiles)
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