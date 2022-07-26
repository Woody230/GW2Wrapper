package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.instance.base.GetClient
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetById
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface GetByIdClient<Model, Id, Value> : GetClient, GetById<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the [Model] associated with the [id].
     */
    suspend fun HttpClient.byId(
        id: Id,
        options: Gw2HttpOptions,
    ): Model = get(options) {
        parameter("id", id.value)
        apply(customizations)
    }.body(modelTypeInfo)

    /**
     * Gets the [Model] associated with the [id], or null if unable to fulfill the request.
     */
    suspend fun HttpClient.byIdOrNull(
        id: Id,
        options: Gw2HttpOptions,
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
        default: (Id) -> Model,
        options: Gw2HttpOptions,
    ): Model = byIdOrNull(id, options) ?: default(id)
}