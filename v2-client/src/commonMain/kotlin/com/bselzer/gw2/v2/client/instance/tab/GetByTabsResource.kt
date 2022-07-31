package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.tab.GetByTabs
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

class GetByTabsResource<Model, Tab, Value>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: TypeInfo,
    private val defaultByTab: (Tab) -> Model
) : GetResource<List<Model>>(typeInfo<List<Model>>()), Gw2ResourceOptions by options,
    GetByTabs<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    private fun Collection<Tab>.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}s associated with tabs ${joinToString(separator = ",")}." }
    private fun Collection<Tab>.parameters(): HttpRequestBuilder.() -> Unit = { parameter("tabs", joinToString(separator = ",")) }

    override suspend fun byTabs(
        tabs: Collection<Tab>,
        options: Gw2HttpOptions
    ): List<Model> = chunked(tabs, options) { chunk ->
        options.getOrThrow(chunk.context(), chunk.parameters())
    }

    override suspend fun byTabsOrEmpty(
        tabs: Collection<Tab>,
        options: Gw2HttpOptions
    ): List<Model> = chunked(tabs, options) { chunk ->
        options.getOrNull(chunk.context(), chunk.parameters()) ?: emptyList()
    }

    override suspend fun byTabsOrDefault(
        tabs: Collection<Tab>,
        options: Gw2HttpOptions
    ): List<Model> {
        val models = byTabsOrEmpty(tabs, options).associateBy { model -> model.id }
        return tabs.map { tab -> models[tab] ?: defaultByTab(tab) }
    }

    private suspend fun chunked(tabs: Collection<Tab>, options: Gw2HttpOptions, get: suspend (Collection<Tab>) -> List<Model>): List<Model> {
        val chunks = tabs.chunked(options.coercedPageSize()).filter { chunk -> chunk.isNotEmpty() }
        return chunks.flatMap { chunk -> get(chunk) }
    }
}