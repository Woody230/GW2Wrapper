package com.bselzer.library.gw2.v2.cache.cache

import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionFinisher
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionStarter
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

abstract class BaseCache<Cache : BaseCache<Cache>>(private val transactionStarter: TransactionStarter, private val transactionFinisher: TransactionFinisher) {
    /**
     * The subclass instance.
     */
    protected abstract val self: Cache

    /**
     * The lock instance.
     */
    private val lock = Mutex()

    /**
     * Executes the [block] under a lock.
     */
    suspend fun withLock(block: suspend Cache.() -> Unit): Unit = lock.withLock { block(self) }

    /**
     * Executes the [block] within a transaction.
     */
    suspend fun transaction(block: suspend Cache.() -> Unit) {
        transactionStarter.begin()
        block(self)
        transactionFinisher.end()
    }

    /**
     * Executes the [block] within a transaction with the lock.
     */
    suspend fun lockedTransaction(block: suspend Cache.() -> Unit): Unit = withLock {
        transaction(block)
    }
}