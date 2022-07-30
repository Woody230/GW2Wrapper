package com.bselzer.gw2.v2.client.instance.search

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.search.GetByName
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

class GetByNameResource<Model>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: TypeInfo,
) : GetResource<List<Model>>(typeInfo<List<Model>>()), Gw2ResourceOptions by options, GetByName<Model> {
    private fun String.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}s with name $this." }
    private fun String.parameters(): HttpRequestBuilder.() -> Unit = { parameter("name", this@parameters) }

    override suspend fun byName(name: String, options: Gw2HttpOptions): List<Model> = options.get(name.context(), name.parameters())
    override suspend fun byNameOrEmpty(name: String, options: Gw2HttpOptions): List<Model> = options.getOrNull(name.context(), name.parameters()) ?: emptyList()
}