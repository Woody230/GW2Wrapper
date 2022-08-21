package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetSinceId
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*

class GetSinceIdResource<Model, Id, Value> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<List<Model>>(genericTypeInfo()), Gw2ResourceOptions by options,
    GetSinceId<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    private fun Id.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}s newer than $this." }
    private fun Id.parameters(): HttpRequestBuilder.() -> Unit = { parameter("since", value) }

    override suspend fun since(id: Id, options: Gw2HttpOptions): GetResult<List<Model>> = options.get(id.context(), id.parameters())
    override suspend fun sinceOrThrow(id: Id, options: Gw2HttpOptions): List<Model> = since(id, options).getOrThrow()
    override suspend fun sinceOrEmpty(id: Id, options: Gw2HttpOptions): List<Model> = since(id, options).getOrNull() ?: emptyList()
}

inline fun <reified Model, Id, Value> ResourceDependencies.getSinceIdResource(
    options: Gw2ResourceOptions
): GetSinceIdResource<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> =
    GetSinceIdResource(
        httpClient,
        options,
        genericTypeInfo()
    )