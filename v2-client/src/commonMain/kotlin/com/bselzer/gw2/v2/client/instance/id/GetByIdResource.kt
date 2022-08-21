package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetById
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * A resource that supports getting a single [Model] by a single [Id].
 */
class GetByIdResource<Model, Id, Value> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
    private val defaultById: (Id) -> Model
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetById<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    private fun Id.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} with id $this." }
    private fun Id.parameters(): HttpRequestBuilder.() -> Unit = { parameter("id", value) }

    override suspend fun byId(id: Id, options: Gw2HttpOptions): GetResult<Model> = options.get(id.context(), id.parameters())
    override suspend fun byIdOrThrow(id: Id, options: Gw2HttpOptions): Model = byId(id, options).getOrThrow()
    override suspend fun byIdOrDefault(id: Id, options: Gw2HttpOptions): Model = byIdOrNull(id, options) ?: defaultById(id)
    override suspend fun byIdOrNull(id: Id, options: Gw2HttpOptions): Model? = byId(id, options).getOrNull()
}

inline fun <reified Model, Id, Value> ResourceDependencies.getByIdResource(
    options: Gw2ResourceOptions,
    noinline defaultById: (Id) -> Model,
): GetByIdResource<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> =
    GetByIdResource(
        httpClient,
        options,
        genericTypeInfo(),
        defaultById
    )