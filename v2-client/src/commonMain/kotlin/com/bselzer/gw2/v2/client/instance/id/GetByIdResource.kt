package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetById
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

/**
 * A resource that supports getting a single [Model] by a single [Id].
 */
class GetByIdResource<Model, Id, Value>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: TypeInfo,
    private val defaultById: (Id) -> Model
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetById<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    private fun Id.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} with id $this." }
    private fun Id.parameters(): HttpRequestBuilder.() -> Unit = { parameter("id", value) }

    override suspend fun byId(id: Id, options: Gw2HttpOptions): Model = options.get(id.context(), id.parameters())
    override suspend fun byIdOrDefault(id: Id, options: Gw2HttpOptions): Model = byIdOrNull(id, options) ?: defaultById(id)
    override suspend fun byIdOrNull(id: Id, options: Gw2HttpOptions): Model? = options.getOrNull(id.context(), id.parameters())
}