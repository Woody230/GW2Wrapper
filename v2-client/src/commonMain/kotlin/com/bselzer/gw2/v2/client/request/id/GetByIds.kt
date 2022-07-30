package com.bselzer.gw2.v2.client.request.id

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetByIds<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Gets the [Model]s associated with the [ids].
     */
    suspend fun byIds(ids: Collection<Id>, options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s associated with the [ids], or an empty list if unable to fulfill the request.
     */
    suspend fun byIdsOrEmpty(ids: Collection<Id>, options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s associated with the [ids], or a defaulted [Model] with the [Id] populated if it is missing from the response.
     */
    suspend fun byIdsOrDefault(ids: Collection<Id>, options: Gw2HttpOptions): List<Model>
}