package com.bselzer.library.gw2.v2.cache.instance

import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.gw2.v2.model.world.World
import com.bselzer.library.kotlin.extension.kodein.db.operation.clear
import com.bselzer.library.kotlin.extension.kodein.db.operation.findAllOnce
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionManager

/**
 * Represents a cache related to the [World] model.
 */
class WorldCache(transactionManager: TransactionManager, client: Gw2Client) : Gw2Cache(transactionManager, client) {
    /**
     * Finds the worlds.
     *
     * If there are no worlds in the database, then the api is called.
     *
     * @return the worlds
     */
    suspend fun findWorlds(): Collection<World> = transaction {
        findAllOnce { client.world.worlds() }
    }

    /**
     * Clears the [World] models.
     */
    override suspend fun clear(): Unit = transaction {
        clear<World>()
    }
}