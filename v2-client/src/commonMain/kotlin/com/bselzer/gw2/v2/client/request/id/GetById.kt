package com.bselzer.gw2.v2.client.request.id

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetById<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Gets the [Model] associated with the [id], or a [GetResult.Failure] if unable to fulfill the request.
     */
    suspend fun byId(id: Id, options: Gw2HttpOptions): GetResult<Model>

    /**
     * Gets the [Model] associated with the [id], or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byIdOrThrow(id: Id, options: Gw2HttpOptions): Model

    /**
     * Gets the [Model] associated with the [id], or null if unable to fulfill the request.
     */
    suspend fun byIdOrNull(id: Id, options: Gw2HttpOptions): Model?

    /**
     * Gets the [Model] associated with the [id], or a defaulted model with the id populated if unable to fulfill the request.
     */
    suspend fun byIdOrDefault(id: Id, options: Gw2HttpOptions): Model
}