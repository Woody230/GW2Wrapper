package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceContext
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.request.tab.GetByAllTabs
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.client.GenericTypeInfo
import com.bselzer.ktx.client.genericTypeInfo
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*

class GetByAllTabsResource<Model, Tab, Value> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<List<Model>>(genericTypeInfo()), Gw2ResourceOptions by options,
    GetByAllTabs<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    private val context: () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} associated with all tabs." }
    private val parameters: HttpRequestBuilder.() -> Unit = { parameter("tabs", "all") }

    override suspend fun byAllTabs(options: Gw2Options): GetResult<List<Model>> = options.get(context, parameters)
    override suspend fun byAllTabsOrThrow(options: Gw2Options): List<Model> = byAllTabs(options).getOrThrow()
    override suspend fun byAllTabsOrEmpty(options: Gw2Options): List<Model> = byAllTabs(options).getOrNull() ?: emptyList()
}

inline fun <reified Model, Tab, Value> Gw2ResourceContext.getByAllTabsResource(
    options: Gw2ResourceOptions
): GetByAllTabsResource<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> =
    GetByAllTabsResource(
        httpClient,
        options,
        genericTypeInfo()
    )