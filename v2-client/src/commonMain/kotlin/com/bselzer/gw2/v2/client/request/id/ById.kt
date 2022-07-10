package com.bselzer.gw2.v2.client.request.id

import com.bselzer.gw2.v2.client.request.GetModel
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface ById<Id, Value, Model> : GetModel where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Gets the [Model] associated with the [id].
     */
    suspend fun HttpClient.byId(
        id: Id,
        options: Gw2HttpOptions,
    ): Model = get(options) {
        parameter("id", id.value)
    }.body(modelTypeInfo)

    /**
     * Gets the [Model] associated with the [id], or null if unable to fulfill the request.
     */
    suspend fun HttpClient.byIdOrNull(
        id: Id,
        options: Gw2HttpOptions
    ): Model? = try {
        byId(id, options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName} with id $id." }
        null
    }

    /**
     * Gets the [Model] associated with the [id], or the [default] model if unable to fulfill the request.
     */
    suspend fun HttpClient.byIdOrDefault(
        id: Id,
        options: Gw2HttpOptions,
        default: (Id) -> Model
    ): Model = byIdOrNull(id, options) ?: default(id)
}