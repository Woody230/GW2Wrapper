package com.bselzer.gw2.v2.tile.cache.instance

import com.bselzer.gw2.v2.tile.cache.metadata.id
import com.bselzer.gw2.v2.tile.client.TileClient
import com.bselzer.gw2.v2.tile.model.request.TileRequest
import com.bselzer.gw2.v2.tile.model.response.Tile
import com.bselzer.gw2.v2.tile.model.response.TileGrid
import com.bselzer.ktx.kodein.db.cache.DBCache
import com.bselzer.ktx.kodein.db.operation.clear
import com.bselzer.ktx.kodein.db.operation.getById
import com.bselzer.ktx.kodein.db.transaction.TransactionManager
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

/**
 * The cache for the [TileClient].
 */
class TileCache(transactionManager: TransactionManager, private val client: TileClient) : DBCache(transactionManager) {
    /**
     * Gets the tile with the same [TileRequest.zoom], [TileRequest.gridX] and [TileRequest.gridY].
     *
     * If there is no tile in the database, then the tile service is called.
     *
     * @param tileRequest the request
     * @return the tile
     */
    suspend fun getTile(tileRequest: TileRequest): Tile = transaction {
        getById(
            id = tileRequest.id(),
            requestSingle = { client.tile(tileRequest) },

            // Only write the tile if its content was successfully retrieved and not defaulted.
            writeFilter = { tile -> tile.content.isNotEmpty() }
        )
    }

    /**
     * Finds the tiles with the same [TileRequest.zoom], [TileRequest.gridX], and [TileRequest.gridY].
     *
     * If there are missing tiles, then the tile service is called.
     *
     * @param tileRequests the requests
     * @return the deferred tiles
     */
    suspend fun findTilesAsync(tileRequests: Collection<TileRequest>): Collection<Deferred<Tile>> = transaction {
        coroutineScope { tileRequests.map { tileRequest -> async { getTile(tileRequest) } } }
    }

    /**
     * Clears the [Tile] and [TileGrid] models.
     */
    suspend fun clear() = transaction {
        clear<Tile>()
        clear<TileGrid>()
    }
}