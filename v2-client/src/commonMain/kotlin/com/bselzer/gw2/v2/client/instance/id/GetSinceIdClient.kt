package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.instance.base.GetClient
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetSinceId
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface GetSinceIdClient<Model, Id, Value> : GetClient, GetSinceId<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the [Model]s newer than the [Model] associated with the [id].
     */
    suspend fun HttpClient.since(
        id: Id,
        options: Gw2HttpOptions
    ): List<Model> = get(options) {
        parameter("since", id.value)
    }.body()

    /**
     * Gets the [Model]s newer than the [Model] associated with the [id], or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.sinceOrEmpty(
        id: Id,
        options: Gw2HttpOptions
    ): List<Model> = try {
        since(id, options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName}s newer than $id." }
        emptyList()
    }
}