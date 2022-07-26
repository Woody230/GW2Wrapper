package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.instance.base.GetClient
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetByIds
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface GetByIdsClient<Model, Id, Value> : GetClient, GetByIds<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the [Model]s associated with the [ids].
     */
    suspend fun HttpClient.byIds(
        ids: Collection<Id>,
        options: Gw2HttpOptions,
    ): List<Model> {
        val chunks = ids.chunked(options.coercedPageSize()).filter { chunk -> chunk.isNotEmpty() }
        return chunks.flatMap { chunk ->
            get(options) {
                parameter("ids", chunk.joinToString(separator = ","))
            }.body<List<Model>>()
        }
    }

    /**
     * Gets the [Model]s associated with the [ids], or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.byIdsOrEmpty(
        ids: Collection<Id>,
        options: Gw2HttpOptions,
    ): List<Model> = try {
        byIds(ids, options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName} with ids ${ids.joinToString()}." }
        emptyList()
    }

    /**
     * Gets the [Model]s associated with the [ids], or a [default] model if it is missing from the response.
     */
    suspend fun HttpClient.byIdsOrDefault(
        ids: Collection<Id>,
        default: (Id) -> Model,
        options: Gw2HttpOptions,
    ): List<Model> {
        val models = byIdsOrEmpty(ids, options).associateBy { model -> model.id }
        return ids.map { id -> models[id] ?: default(id) }
    }
}