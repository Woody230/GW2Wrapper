package com.bselzer.library.gw2.v2.cache.cache

import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.kotlin.extension.kodein.db.transaction.DBTransactionProvider
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionFinisher
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionStarter

/**
 * The caching abstraction for the GW2 API.
 *
 * @param transactionStarter the transaction starter
 * @param transactionFinisher the transaction finisher
 * @param client the GW2 API client
 */
class Gw2Cache(private val transactionStarter: TransactionStarter, private val transactionFinisher: TransactionFinisher, client: Gw2Client) :
    BaseCache<Gw2Cache>(transactionStarter, transactionFinisher) {
    override val self: Gw2Cache = this

    /**
     * Initializes a new instance of the [Gw2Cache] class with the [DBTransactionProvider] as the transaction starter and finisher.
     */
    constructor(transactionProvider: DBTransactionProvider, client: Gw2Client) : this(transactionProvider, transactionProvider, client)

    val continent = ContinentCache(transactionStarter, client)
    val world = WorldCache(transactionStarter, client)
    val wvw = WvwCache(transactionStarter, client)

    /**
     * @return a new [Gw2Cache] with an updated [client]
     */
    fun client(client: Gw2Client): Gw2Cache = Gw2Cache(transactionStarter, transactionFinisher, client)
}