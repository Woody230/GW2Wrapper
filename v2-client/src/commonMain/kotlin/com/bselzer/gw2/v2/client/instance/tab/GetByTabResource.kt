package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.tab.GetByTab
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*

class GetByTabResource<Model, Tab, Value> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
    private val defaultByTab: (Tab) -> Model
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetByTab<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    private fun Tab.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} associated with tab $this." }
    private fun Tab.parameters(): HttpRequestBuilder.() -> Unit = { parameter("tab", value) }

    override suspend fun byTab(tab: Tab, options: Gw2HttpOptions): Result<Model> = options.get(tab.context(), tab.parameters())
    override suspend fun byTabOrThrow(tab: Tab, options: Gw2HttpOptions): Model = byTab(tab, options).getOrThrow()
    override suspend fun byTabOrNull(tab: Tab, options: Gw2HttpOptions): Model? = byTab(tab, options).getOrNull()
    override suspend fun byTabOrDefault(tab: Tab, options: Gw2HttpOptions): Model = byTabOrNull(tab, options) ?: defaultByTab(tab)
}

inline fun <reified Model, Tab, Value> ResourceDependencies.getByTabResource(
    options: Gw2ResourceOptions,
    noinline defaultByTab: (Tab) -> Model
): GetByTabResource<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> =
    GetByTabResource(
        httpClient,
        options,
        genericTypeInfo(),
        defaultByTab
    )