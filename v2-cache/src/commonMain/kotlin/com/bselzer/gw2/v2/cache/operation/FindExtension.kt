package com.bselzer.gw2.v2.cache.operation

import com.bselzer.ktx.kodein.db.transaction.Transaction
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import org.kodein.db.find
import org.kodein.db.useModels

/**
 * Finds the [Reference] models from the database based on an id found on an [Origin] model.
 *
 * @param origin the models to get an id from
 * @param getId the function for mapping an [Origin] model to a [Reference] [Value]
 * @param Origin the type of the model with the reference id
 * @param Id the type of the id of the [Reference] model
 * @param Reference the type of the model to retrieve
 */
inline fun <Origin, Value, Id : Identifier<Value>, reified Reference : Identifiable<Value>> Transaction.findByReferenceId(
    origin: Collection<Origin>,
    crossinline getId: Origin.() -> Id
): Collection<Reference> {
    val ids = origin.map(getId)
    return reader.find<Reference>().all().useModels { it.filter { reference -> ids.contains(reference.id) }.toList() }
}

/**
 * Finds the [Reference] models from the database based on ids found on an [Origin] model.
 *
 * @param origin the models to get ids from
 * @param getIds the function for mapping an [Origin] model to one or more [Reference] [Value]s
 * @param Origin the type of the model with the reference ids
 * @param Id the type of the id of the [Reference] model
 * @param Reference the type of the model to retrieve
 */
inline fun <Origin, Value, Id : Identifier<Value>, reified Reference : Identifiable<Value>> Transaction.findByReferenceIds(
    origin: Collection<Origin>,
    crossinline getIds: Origin.() -> Collection<Id>
): Collection<Reference> {
    val ids = origin.flatMap(getIds)
    return reader.find<Reference>().all().useModels { it.filter { reference -> ids.contains(reference.id) }.toList() }
}