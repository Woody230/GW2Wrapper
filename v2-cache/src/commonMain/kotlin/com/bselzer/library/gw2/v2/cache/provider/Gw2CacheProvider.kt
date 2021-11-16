package com.bselzer.library.gw2.v2.cache.provider

import com.bselzer.library.gw2.v2.cache.instance.ContinentCache
import com.bselzer.library.gw2.v2.cache.instance.Gw2Cache
import com.bselzer.library.gw2.v2.cache.instance.WorldCache
import com.bselzer.library.gw2.v2.cache.instance.WvwCache
import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.kotlin.extension.kodein.db.cache.DBCacheProvider
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionFinisher
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionStarter

/**
 * The caching abstraction for GW2 instances.
 *
 * @param transactionStarter the transaction starter
 * @param transactionFinisher the transaction finisher
 */
class Gw2CacheProvider(private val transactionStarter: TransactionStarter, transactionFinisher: TransactionFinisher) :
    DBCacheProvider<Gw2Cache, Gw2CacheProvider>(transactionStarter, transactionFinisher) {
    override val instance: Gw2CacheProvider = this

    /**
     * Injects the GW2 caches into the provider.
     */
    fun inject(client: Gw2Client) {
        set(ContinentCache(transactionStarter, client))
        set(WorldCache(transactionStarter, client))
        set(WvwCache(transactionStarter, client))
    }
}