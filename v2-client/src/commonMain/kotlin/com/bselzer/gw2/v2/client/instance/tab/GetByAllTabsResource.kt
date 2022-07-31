package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.tab.GetByAllTabs
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*

class GetByAllTabsResource<Model, Tab, Value>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<List<Model>>(genericTypeInfo()), Gw2ResourceOptions by options,
    GetByAllTabs<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    private val context: () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} associated with all tabs." }
    private val parameters: HttpRequestBuilder.() -> Unit = { parameter("tabs", "all") }

    override suspend fun byAllTabs(options: Gw2HttpOptions): List<Model> = options.getOrThrow(context, parameters)
    override suspend fun byAllTabsOrEmpty(options: Gw2HttpOptions): List<Model> = options.getOrNull(context, parameters) ?: emptyList()
}