package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.tab.GetTabs
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

class GetTabsResource<Tab>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val tabTypeInfo: TypeInfo,
) : GetResource<List<Tab>>(typeInfo<List<Tab>>()), Gw2ResourceOptions by options, GetTabs<Tab> where Tab : Identifier<*> {
    private val context: () -> String = { "Request for ${tabTypeInfo.toDisplayableString()}s." }
    private val parameters: HttpRequestBuilder.() -> Unit = {}

    override suspend fun tabs(options: Gw2HttpOptions): List<Tab> = options.getOrThrow(context, parameters)
    override suspend fun tabsOrEmpty(options: Gw2HttpOptions): List<Tab> = options.getOrNull(context, parameters) ?: emptyList()
}