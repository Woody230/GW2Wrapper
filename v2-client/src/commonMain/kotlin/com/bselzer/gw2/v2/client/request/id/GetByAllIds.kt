package com.bselzer.gw2.v2.client.request.id

import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetByAllIds<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Gets the [Model]s using all ids.
     */
    suspend fun byAllIds(options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s using all ids, or an empty list if unable to fulfill the request.
     */
    suspend fun byAllIdsOrEmpty(options: Gw2HttpOptions): List<Model>
}