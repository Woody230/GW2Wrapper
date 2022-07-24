package com.bselzer.gw2.v2.client.request.id

import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetById<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Gets the [Model] associated with the [id].
     */
    suspend fun byId(id: Id, options: Gw2HttpOptions): Model

    /**
     * Gets the [Model] associated with the [id], or null if unable to fulfill the request.
     */
    suspend fun byIdOrNull(id: Id, options: Gw2HttpOptions): Model?

    /**
     * Gets the [Model] associated with the [id], or the [default] model if unable to fulfill the request.
     */
    suspend fun byIdOrDefault(id: Id, default: (Id) -> Model, options: Gw2HttpOptions): Model
}