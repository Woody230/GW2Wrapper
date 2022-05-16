package com.bselzer.gw2.v2.tile.cache.instance

import com.bselzer.gw2.v2.tile.cache.metadata.id
import com.bselzer.gw2.v2.tile.client.TileClient
import com.bselzer.gw2.v2.tile.model.request.TileRequest
import com.bselzer.gw2.v2.tile.model.response.Tile
import com.bselzer.gw2.v2.tile.model.response.TileGrid
import com.bselzer.ktx.kodein.db.cache.Cache
import com.bselzer.ktx.kodein.db.operation.clear
import com.bselzer.ktx.kodein.db.operation.getById
import com.bselzer.ktx.kodein.db.transaction.Transaction
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

/**
 * The cache for the [TileClient].
 */
class TileCache(private val client: TileClient) : Cache {
    /**
     * Gets the tile with the same [TileRequest.zoom], [TileRequest.gridX] and [TileRequest.gridY].
     *
     * If there is no tile in the database, then the tile service is called.
     *
     * @param tileRequest the request
     * @return the tile
     */
    suspend fun Transaction.getTile(tileRequest: TileRequest): Tile = getById(
        id = tileRequest.id(),
        requestSingle = { client.tile(tileRequest) },

        // Only write the tile if its content was successfully retrieved and not defaulted.
        writeFilter = { tile -> tile.content.isNotEmpty() }
    )

    /**
     * Finds the tiles with the same [TileRequest.zoom], [TileRequest.gridX], and [TileRequest.gridY].
     *
     * If there are missing tiles, then the tile service is called.
     *
     * @param tileRequests the requests
     * @return the deferred tiles
     */
    suspend fun Transaction.findTilesAsync(tileRequests: Collection<TileRequest>): Collection<Deferred<Tile>> = coroutineScope {
        tileRequests.map { tileRequest ->
            async { getTile(tileRequest) }
        }
    }

    /**
     * Clears the [Tile] and [TileGrid] models.
     */
    override fun Transaction.clear() {
        clear<Tile>()
        clear<TileGrid>()
    }
}