package com.bselzer.gw2.v2.client.request.id

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetSinceId<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Gets the [Model]s newer than the [Model] associated with the [id].
     */
    suspend fun since(id: Id, options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s newer than the [Model] associated with the [id], or an empty list if unable to fulfill the request.
     */
    suspend fun sinceOrEmpty(id: Id, options: Gw2HttpOptions): List<Model>
}