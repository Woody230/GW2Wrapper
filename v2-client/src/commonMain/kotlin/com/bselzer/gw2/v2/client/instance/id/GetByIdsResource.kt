package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.AggregateListResult
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetByIds
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * A resource that supports getting multiple [Model]s using multiple [Id]s.
 */
class GetByIdsResource<Model, Id, Value> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
    private val defaultById: (Id) -> Model
) : GetResource<List<Model>>(genericTypeInfo()), Gw2ResourceOptions by options,
    GetByIds<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    private fun Collection<Id>.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} with ids ${joinToString(separator = ",")}." }
    private fun Collection<Id>.parameters(): HttpRequestBuilder.() -> Unit = { parameter("ids", joinToString(separator = ",")) }

    override suspend fun byIds(ids: Collection<Id>, options: Gw2HttpOptions): AggregateListResult<Model> {
        val chunks = ids.chunked(options.coercedPageSize()).filter { chunk -> chunk.isNotEmpty() }
        val results = chunks.map { chunk -> options.get(chunk.context(), chunk.parameters()) }
        return AggregateListResult(results)
    }

    override suspend fun byIdsOrThrow(
        ids: Collection<Id>,
        options: Gw2HttpOptions
    ): List<Model> = byIds(ids, options).getOrThrow()

    override suspend fun byIdsOrEmpty(
        ids: Collection<Id>,
        options: Gw2HttpOptions
    ): List<Model> = byIds(ids, options).getOrEmpty()

    override suspend fun byIdsOrDefault(
        ids: Collection<Id>,
        options: Gw2HttpOptions
    ): List<Model> {
        val models = byIdsOrEmpty(ids, options).associateBy { model -> model.id }
        return ids.map { id -> models[id] ?: defaultById(id) }
    }
}

inline fun <reified Model, Id, Value> getByIdsResource(
    httpClient: HttpClient,
    options: Gw2ResourceOptions,
    noinline defaultById: (Id) -> Model,
): GetByIdsResource<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> = GetByIdsResource(httpClient, options, genericTypeInfo(), defaultById)