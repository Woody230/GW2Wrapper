package com.bselzer.library.gw2.v2.cache.cache

import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.gw2.v2.model.world.World
import com.bselzer.library.kotlin.extension.kodein.db.operation.clear
import com.bselzer.library.kotlin.extension.kodein.db.operation.findAllOnce
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionStarter

/**
 * Represents a cache related to the [World] model.
 */
class WorldCache(transactionStarter: TransactionStarter, client: Gw2Client) : BaseCache(transactionStarter, client) {
    /**
     * Finds the worlds.
     *
     * If there are no worlds in the database, then the api is called.
     *
     * @return the worlds
     */
    suspend fun findWorlds(): Sequence<World> = runTransaction {
        findAllOnce { client.world.worlds() }
    }

    /**
     * Clears the [World] models.
     */
    override suspend fun clear() = transaction {
        clear<World>()
    }
}