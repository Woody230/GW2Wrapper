package com.bselzer.gw2.v2.client.instance.search

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceContext
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.request.search.GetByName
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.client.GenericTypeInfo
import com.bselzer.ktx.client.genericTypeInfo
import io.ktor.client.*
import io.ktor.client.request.*

class GetByNameResource<Model> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<List<Model>>(genericTypeInfo()), Gw2ResourceOptions by options, GetByName<Model> {
    private fun String.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}s with name $this." }
    private fun String.parameters(): HttpRequestBuilder.() -> Unit = { parameter("name", this@parameters) }

    override suspend fun byName(name: String, options: Gw2Options): GetResult<List<Model>> = options.get(name.context(), name.parameters())
    override suspend fun byNameOrThrow(name: String, options: Gw2Options): List<Model> = byName(name, options).getOrThrow()
    override suspend fun byNameOrEmpty(name: String, options: Gw2Options): List<Model> = byName(name, options).getOrNull() ?: emptyList()
}

inline fun <reified Model> Gw2ResourceContext.getByNameResource(
    options: Gw2ResourceOptions
): GetByNameResource<Model> = GetByNameResource(
    httpClient,
    options,
    genericTypeInfo()
)