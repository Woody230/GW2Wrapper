package com.bselzer.library.gw2.v2.tile.cache.instance

import com.bselzer.library.gw2.v2.tile.cache.metadata.id
import com.bselzer.library.gw2.v2.tile.client.TileClient
import com.bselzer.library.gw2.v2.tile.model.request.TileRequest
import com.bselzer.library.gw2.v2.tile.model.response.Tile
import com.bselzer.library.gw2.v2.tile.model.response.TileGrid
import com.bselzer.library.kotlin.extension.kodein.db.cache.DBCache
import com.bselzer.library.kotlin.extension.kodein.db.operation.clear
import com.bselzer.library.kotlin.extension.kodein.db.operation.getById
import com.bselzer.library.kotlin.extension.kodein.db.operation.putMissingById
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionStarter
import org.kodein.db.asModelSequence
import org.kodein.db.find

/**
 * The cache for the [TileClient].
 */
class TileCache(transactionStarter: TransactionStarter, private val client: TileClient): DBCache(transactionStarter)
{
    /**
     * Gets the tile with the same [TileRequest.zoom], [TileRequest.x] and [TileRequest.y].
     *
     * If there is no tile in the database, then the tile service is called.
     *
     * @param tileRequest the request
     * @return the tile
     */
    suspend fun getTile(tileRequest: TileRequest): Tile = runTransaction {
        getById(tileRequest.id(), { client.tile(tileRequest) })
    }

    /**
     * Finds the tiles with the same [TileRequest.zoom], [TileRequest.x], and [TileRequest.y].
     *
     * If there are missing tiles, then they are not resolved with a call to the tile service. A call to [putTiles] should be made first instead.
     *
     * @param tileRequests the requests
     * @return the tiles
     */
    suspend fun findTiles(tileRequests: Collection<TileRequest>): Sequence<Tile> = runTransaction {
        val ids = tileRequests.map { tileRequest -> tileRequest.id() }
        reader.find<Tile>().all().asModelSequence().filter { tile -> ids.contains(tile.id()) }
    }

    /**
     * Puts the tiles missing from the database by calling the tile service.
     *
     * @param tileRequests the requests
     */
    suspend fun putTiles(tileRequests: Collection<TileRequest>) = transaction {
        putMissingById(
            requestIds = { tileRequests.map { tileRequest -> tileRequest.id() } },
            requestById = { ids -> tileRequests.filter { tileRequest -> ids.contains(tileRequest.id()) }
                // MUST defer all calls first before awaiting for parallelism.
                .map { tileRequest -> client.tileAsync(tileRequest) }
                .map { deferred -> deferred.await() }
            }
        )
    }

    /**
     * Clears the [Tile] and [TileGrid] models.
     */
    suspend fun clear() = transaction {
        clear<Tile>()
        clear<TileGrid>()
    }
}