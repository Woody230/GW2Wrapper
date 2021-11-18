package com.bselzer.library.gw2.v2.cache.provider

import com.bselzer.library.gw2.v2.cache.instance.ContinentCache
import com.bselzer.library.gw2.v2.cache.instance.Gw2Cache
import com.bselzer.library.gw2.v2.cache.instance.WorldCache
import com.bselzer.library.gw2.v2.cache.instance.WvwCache
import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.kotlin.extension.kodein.db.cache.DBCacheProvider
import org.kodein.db.DB

/**
 * The caching abstraction for GW2 instances.
 */
class Gw2CacheProvider(database: DB) : DBCacheProvider<Gw2Cache, Gw2CacheProvider>(database) {

    override val instance: Gw2CacheProvider = this

    /**
     * Injects the GW2 caches into the provider.
     */
    fun inject(client: Gw2Client) {
        set(ContinentCache(this, client))
        set(WorldCache(this, client))
        set(WvwCache(this, client))
    }
}