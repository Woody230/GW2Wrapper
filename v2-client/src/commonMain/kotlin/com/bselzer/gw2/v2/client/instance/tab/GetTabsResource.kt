package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceContext
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.request.tab.GetTabs
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.client.GenericTypeInfo
import com.bselzer.ktx.client.genericTypeInfo
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*

class GetTabsResource<Tab> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val tabTypeInfo: GenericTypeInfo<Tab>,
) : GetResource<List<Tab>>(genericTypeInfo()), Gw2ResourceOptions by options, GetTabs<Tab> where Tab : Identifier<*> {
    private val context: () -> String = { "Request for ${tabTypeInfo.toDisplayableString()}s." }
    private val parameters: HttpRequestBuilder.() -> Unit = {}

    override suspend fun tabs(options: Gw2Options): GetResult<List<Tab>> = options.get(context, parameters)
    override suspend fun tabsOrThrow(options: Gw2Options): List<Tab> = tabs(options).getOrThrow()
    override suspend fun tabsOrEmpty(options: Gw2Options): List<Tab> = tabs(options).getOrNull() ?: emptyList()
}

inline fun <reified Tab> Gw2ResourceContext.getTabsResource(
    options: Gw2ResourceOptions
): GetTabsResource<Tab> where Tab : Identifier<*> =
    GetTabsResource(
        httpClient,
        options,
        genericTypeInfo()
    )