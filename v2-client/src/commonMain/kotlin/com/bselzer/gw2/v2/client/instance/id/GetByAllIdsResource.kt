package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetByAllIds
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.client.GenericTypeInfo
import com.bselzer.ktx.client.genericTypeInfo
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * A resource that supports getting all [Model]s using all [Id]s.
 */
class GetByAllIdsResource<Model, Id, Value> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<List<Model>>(genericTypeInfo()), Gw2ResourceOptions by options,
    GetByAllIds<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    private val context: () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} with all ids." }
    private val parameters: HttpRequestBuilder.() -> Unit = { parameter("ids", "all") }

    override suspend fun byAllIds(options: Gw2HttpOptions): GetResult<List<Model>> = options.get(context, parameters)
    override suspend fun byAllIdsOrThrow(options: Gw2HttpOptions): List<Model> = byAllIds(options).getOrThrow()
    override suspend fun byAllIdsOrEmpty(options: Gw2HttpOptions): List<Model> = byAllIds(options).getOrNull() ?: emptyList()
}

inline fun <reified Model, Id, Value> ResourceDependencies.getByAllIdsResource(
    options: Gw2ResourceOptions
): GetByAllIdsResource<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> =
    GetByAllIdsResource(
        httpClient,
        options,
        genericTypeInfo()
    )