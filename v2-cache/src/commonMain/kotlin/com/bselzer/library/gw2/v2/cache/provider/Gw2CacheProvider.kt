package com.bselzer.library.gw2.v2.cache.provider

import com.bselzer.library.gw2.v2.cache.instance.ContinentCache
import com.bselzer.library.gw2.v2.cache.instance.WorldCache
import com.bselzer.library.gw2.v2.cache.instance.WvwCache
import com.bselzer.library.gw2.v2.client.client.Gw2Client

/**
 * The caching abstraction for the GW2 API.
 *
 * @param cacheProvider the caching instance
 */
class Gw2CacheProvider(private val cacheProvider: CacheProvider) {
    /**
     * Injects the GW2 caches into the provider.
     */
    fun inject(client: Gw2Client): Unit = cacheProvider.run {
        set(ContinentCache(transactionStarter, client))
        set(WorldCache(transactionStarter, client))
        set(WvwCache(transactionStarter, client))
    }
}