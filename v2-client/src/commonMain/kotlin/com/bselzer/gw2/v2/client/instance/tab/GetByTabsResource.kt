package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.tab.GetByTabs
import com.bselzer.gw2.v2.client.result.AggregateGetResult
import com.bselzer.gw2.v2.client.result.getOrEmpty
import com.bselzer.gw2.v2.client.result.getOrThrow
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*

class GetByTabsResource<Model, Tab, Value> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
    private val defaultByTab: (Tab) -> Model
) : GetResource<List<Model>>(genericTypeInfo()), Gw2ResourceOptions by options,
    GetByTabs<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    private fun Collection<Tab>.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}s associated with tabs ${joinToString(separator = ",")}." }
    private fun Collection<Tab>.parameters(): HttpRequestBuilder.() -> Unit = { parameter("tabs", joinToString(separator = ",")) }

    override suspend fun byTabs(tabs: Collection<Tab>, options: Gw2HttpOptions): AggregateGetResult<Model> {
        val chunks = tabs.chunked(options.coercedPageSize()).filter { chunk -> chunk.isNotEmpty() }
        return chunks.map { chunk -> options.get(chunk.context(), chunk.parameters()) }
    }

    override suspend fun byTabsOrThrow(
        tabs: Collection<Tab>,
        options: Gw2HttpOptions
    ): List<Model> = byTabs(tabs, options).getOrThrow()

    override suspend fun byTabsOrEmpty(
        tabs: Collection<Tab>,
        options: Gw2HttpOptions
    ): List<Model> = byTabs(tabs, options).getOrEmpty()

    override suspend fun byTabsOrDefault(
        tabs: Collection<Tab>,
        options: Gw2HttpOptions
    ): List<Model> {
        val models = byTabsOrEmpty(tabs, options).associateBy { model -> model.id }
        return tabs.map { tab -> models[tab] ?: defaultByTab(tab) }
    }
}

inline fun <reified Model, Tab, Value> ResourceDependencies.getByTabsResource(
    options: Gw2ResourceOptions,
    noinline defaultByTab: (Tab) -> Model
): GetByTabsResource<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> =
    GetByTabsResource(
        httpClient,
        options,
        genericTypeInfo(),
        defaultByTab
    )