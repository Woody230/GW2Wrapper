package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.tab.GetByTab
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

class GetByTabResource<Model, Tab, Value>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: TypeInfo,
    private val defaultByTab: (Tab) -> Model
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetByTab<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    private fun Tab.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} associated with tab $this." }
    private fun Tab.parameters(): HttpRequestBuilder.() -> Unit = { parameter("tab", value) }

    override suspend fun byTab(tab: Tab, options: Gw2HttpOptions): Model = options.get(tab.context(), tab.parameters())
    override suspend fun byTabOrNull(tab: Tab, options: Gw2HttpOptions): Model? = options.getOrNull(tab.context(), tab.parameters())
    override suspend fun byTabOrDefault(tab: Tab, options: Gw2HttpOptions): Model = byTabOrNull(tab, options) ?: defaultByTab(tab)
}