package com.bselzer.library.gw2.v2.cache

import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.kotlin.extension.kodein.db.transaction.DBTransactionProvider
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionFinisher
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionStarter
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

// TODO DB: set up type table and serializers
/**
 * The caching abstraction for the GW2 API.
 *
 * @param transactionStarter the transaction starter
 * @param transactionFinisher the transaction finisher
 * @param client the GW2 API client
 */
class Gw2Cache(private val transactionStarter: TransactionStarter, private val transactionFinisher: TransactionFinisher, client: Gw2Client) {
    /**
     * Initializes a new instance of the [Gw2Cache] class with the [DBTransactionProvider] as the transaction starter and finisher.
     */
    constructor(transactionProvider: DBTransactionProvider, client: Gw2Client) : this(transactionProvider, transactionProvider, client)

    val continent = ContinentCache(transactionStarter, client)
    val world = WorldCache(transactionStarter, client)
    val wvw = WvwCache(transactionStarter, client)

    /**
     * The lock instance.
     */
    private val lock = Mutex()

    /**
     * Executes the [block] under a lock.
     */
    suspend fun withLock(block: suspend Gw2Cache.() -> Unit): Unit = lock.withLock { block(this) }

    /**
     * Executes the [block] within a transaction.
     */
    suspend fun transaction(block: suspend Gw2Cache.() -> Unit) {
        transactionStarter.begin()
        block(this)
        transactionFinisher.end()
    }

    /**
     * Executes the [block] within a transaction with the lock.
     */
    suspend fun lockedTransaction(block: suspend Gw2Cache.() -> Unit): Unit = withLock {
        transaction(block)
    }

    /**
     * @return a new [Gw2Cache] with an updated [client]
     */
    fun client(client: Gw2Client): Gw2Cache = Gw2Cache(transactionStarter, transactionFinisher, client)
}