package com.bselzer.library.gw2.v2.cache.instance

import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.kotlin.extension.kodein.db.cache.DBCache
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionManager
import org.kodein.db.find
import org.kodein.db.useModels

/**
 * The base [Gw2Client] cache instance.
 */
abstract class Gw2Cache(transactionManager: TransactionManager, protected val client: Gw2Client) : DBCache(transactionManager) {
    /**
     * Clears the database of all relevant models.
     */
    abstract suspend fun clear()

    /**
     * Finds the [Reference] models from the database based on an id found on an [Origin] model.
     *
     * @param origin the models to get an id from
     * @param getId the function for mapping an [Origin] model to a [Reference] [Id]
     * @param Origin the type of the model with the reference id
     * @param Id the type of the id of the [Reference] model
     * @param Reference the type of the model to retrieve
     */
    protected suspend inline fun <Origin, Id, reified Reference : Identifiable<Id>> findByReferenceId(
        origin: Collection<Origin>,
        crossinline getId: Origin.() -> Id
    ): Collection<Reference> = transaction { db ->
        val ids = origin.map(getId)
        db.reader.find<Reference>().all().useModels { it.filter { reference -> ids.contains(reference.id) }.toList() }
    }

    /**
     * Finds the [Reference] models from the database based on ids found on an [Origin] model.
     *
     * @param origin the models to get ids from
     * @param getIds the function for mapping an [Origin] model to one or more [Reference] [Id]s
     * @param Origin the type of the model with the reference ids
     * @param Id the type of the id of the [Reference] model
     * @param Reference the type of the model to retrieve
     */
    protected suspend inline fun <Origin, Id, reified Reference : Identifiable<Id>> findByReferenceIds(
        origin: Collection<Origin>,
        crossinline getIds: Origin.() -> Collection<Id>
    ): Collection<Reference> = transaction { db ->
        val ids = origin.flatMap(getIds)
        db.reader.find<Reference>().all().useModels { it.filter { reference -> ids.contains(reference.id) }.toList() }
    }
}