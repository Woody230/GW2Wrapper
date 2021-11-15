package com.bselzer.library.gw2.v2.cache.cache

import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.kotlin.extension.kodein.db.transaction.DBTransaction
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionStarter

abstract class BaseCache(private val transactionStarter: TransactionStarter, protected val client: Gw2Client) {
    /**
     * Executes the [block] for the current transaction.
     *
     * @param block the transaction function
     */
    protected suspend fun transaction(block: suspend DBTransaction.() -> Unit): Unit = runTransaction(block)

    /**
     * Executes the [block] for the current transition.
     *
     * @param block the transaction function
     * @return the result of the [block]
     */
    protected suspend fun <R> runTransaction(block: suspend DBTransaction.() -> R): R {
        val transaction = transactionStarter.begin()
        return block(transaction)
    }

    /**
     * Clears the database of all relevant models.
     */
    abstract suspend fun clear()
}