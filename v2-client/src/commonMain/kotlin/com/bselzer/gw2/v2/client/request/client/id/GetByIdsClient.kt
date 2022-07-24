package com.bselzer.gw2.v2.client.request.client.id

import com.bselzer.gw2.v2.client.request.client.model.GetModelClient
import com.bselzer.gw2.v2.client.request.id.GetByIds
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface GetByIdsClient<Model, Id, Value> : GetModelClient<Model>, GetByIds<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Gets the [Model]s associated with the [ids].
     */
    suspend fun HttpClient.byIds(
        ids: Collection<Id>,
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Model> {
        val chunks = ids.chunked(options.coercedPageSize()).filter { chunk -> chunk.isNotEmpty() }
        return chunks.flatMap { chunk ->
            get(options) {
                parameter("ids", chunk.joinToString(separator = ","))
                apply(customizations)
            }.body<List<Model>>()
        }
    }

    /**
     * Gets the [Model]s associated with the [ids], or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.byIdsOrEmpty(
        ids: Collection<Id>,
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Model> = try {
        byIds(ids, options, customizations)
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
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Model> {
        val models = byIdsOrEmpty(ids, options, customizations).associateBy { model -> model.id }
        return ids.map { id -> models[id] ?: default(id) }
    }
}