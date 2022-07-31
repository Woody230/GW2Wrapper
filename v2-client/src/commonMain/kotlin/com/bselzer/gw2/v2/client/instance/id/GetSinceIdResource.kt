package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetSinceId
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

class GetSinceIdResource<Model, Id, Value>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: TypeInfo,
) : GetResource<List<Model>>(typeInfo<List<Model>>()), Gw2ResourceOptions by options,
    GetSinceId<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    private fun Id.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}s newer than $this." }
    private fun Id.parameters(): HttpRequestBuilder.() -> Unit = { parameter("since", value) }

    override suspend fun since(id: Id, options: Gw2HttpOptions): List<Model> = options.getOrThrow(id.context(), id.parameters())
    override suspend fun sinceOrEmpty(id: Id, options: Gw2HttpOptions): List<Model> = options.getOrNull(id.context(), id.parameters()) ?: emptyList()
}