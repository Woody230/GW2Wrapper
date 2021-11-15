package com.bselzer.library.gw2.v2.cache.instance

import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.kotlin.extension.kodein.db.cache.DBCache
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionStarter

/**
 * The base GW2 cache instance.
 */
abstract class Gw2Cache(transactionStarter: TransactionStarter, protected val client: Gw2Client) : DBCache(transactionStarter) {
    /**
     * Clears the database of all relevant models.
     */
    abstract suspend fun clear()
}