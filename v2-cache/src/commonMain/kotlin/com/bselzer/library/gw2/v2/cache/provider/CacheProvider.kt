package com.bselzer.library.gw2.v2.cache.provider

import com.bselzer.library.gw2.v2.cache.instance.BaseCache
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionFinisher
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionStarter
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.reflect.KClass

/**
 * The caching abstraction for multiple instances.
 *
 * @param transactionStarter the transaction starter
 * @param transactionFinisher the transaction finisher
 */
open class CacheProvider(val transactionStarter: TransactionStarter, val transactionFinisher: TransactionFinisher) {
    /**
     * The underlying caches.
     */
    @PublishedApi
    internal val caches: MutableMap<KClass<out BaseCache>, BaseCache> = mutableMapOf()

    /**
     * The lock instance.
     */
    private val lock = Mutex()

    /**
     * Executes the [block] under a lock.
     */
    suspend fun withLock(block: suspend CacheProvider.() -> Unit): Unit = lock.withLock { block(this) }

    /**
     * Executes the [block] within a transaction.
     */
    suspend fun transaction(block: suspend CacheProvider.() -> Unit) {
        transactionStarter.begin()
        block(this)
        transactionFinisher.end()
    }

    /**
     * Executes the [block] within a transaction with the lock.
     */
    suspend fun lockedTransaction(block: suspend CacheProvider.() -> Unit): Unit = withLock {
        transaction(block)
    }

    /**
     * Gets the cache that is of the same type as [Cache].
     *
     * @throws NoSuchElementException if the cache does not exist
     * @return the cache
     */
    inline fun <reified Cache : BaseCache> get(): Cache = caches[Cache::class] as? Cache
        ?: throw NoSuchElementException("Unable to find the cache of type ${Cache::class}.")

    /**
     * Sets the cache with a type of [Cache].
     */
    inline fun <reified Cache : BaseCache> set(cache: Cache) {
        caches[Cache::class] = cache
    }
}