package com.bselzer.gw2.v2.cache.instance

import com.bselzer.gw2.v2.client.client.Gw2Client
import com.bselzer.gw2.v2.model.world.World
import com.bselzer.ktx.kodein.db.cache.Cache
import com.bselzer.ktx.kodein.db.operation.clear
import com.bselzer.ktx.kodein.db.operation.findAllOnce
import com.bselzer.ktx.kodein.db.transaction.Transaction

/**
 * Represents a cache related to the [World] model.
 */
class WorldCache(private val client: Gw2Client) : Cache {
    /**
     * Finds the worlds.
     *
     * If there are no worlds in the database, then the api is called.
     *
     * @return the worlds
     */
    suspend fun Transaction.findWorlds(): Collection<World> {
        return findAllOnce { client.world.worlds() }
    }

    /**
     * Clears the [World] models.
     */
    override fun Transaction.clear() {
        clear<World>()
    }
}