package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetByIds
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

class GetByIdsResource<Model, Id, Value>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: TypeInfo,
) : GetResource<List<Model>>(typeInfo<List<Model>>()), Gw2ResourceOptions by options,
    GetByIds<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    private fun Collection<Id>.context(): () -> String = { "Request for ${modelTypeInfo.type.simpleName} with ids ${joinToString(separator = ",")}." }
    private fun Collection<Id>.parameters(): HttpRequestBuilder.() -> Unit = { parameter("ids", joinToString(separator = ",")) }

    override suspend fun byIds(
        ids: Collection<Id>,
        options: Gw2HttpOptions
    ): List<Model> = chunked(ids, options) { chunk ->
        options.get(chunk.context(), chunk.parameters())
    }

    override suspend fun byIdsOrEmpty(
        ids: Collection<Id>,
        options: Gw2HttpOptions
    ): List<Model> = chunked(ids, options) { chunk ->
        options.getOrNull(chunk.context(), chunk.parameters()) ?: emptyList()
    }

    override suspend fun byIdsOrDefault(
        ids: Collection<Id>,
        default: (Id) -> Model,
        options: Gw2HttpOptions
    ): List<Model> {
        val models = byIdsOrEmpty(ids, options).associateBy { model -> model.id }
        return ids.map { id -> models[id] ?: default(id) }
    }

    private suspend fun chunked(ids: Collection<Id>, options: Gw2HttpOptions, get: suspend (Collection<Id>) -> List<Model>): List<Model> {
        val chunks = ids.chunked(options.coercedPageSize()).filter { chunk -> chunk.isNotEmpty() }
        return chunks.flatMap { chunk -> get(chunk) }
    }
}