package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.tab.GetByActiveTab
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.reflect.*

class GetByActiveTabResource<Model, Tab, Value>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: TypeInfo,
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetByActiveTab<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    private val context: () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} associated with the active tab." }
    private val parameters: HttpRequestBuilder.() -> Unit = {
        url { appendPathSegments("active") }
    }

    override suspend fun byActiveTab(options: Gw2HttpOptions): Model = options.get(context, parameters)
    override suspend fun byActiveTabOrNull(options: Gw2HttpOptions): Model? = options.getOrNull(context, parameters)
    override suspend fun byActiveTabOrDefault(default: () -> Model, options: Gw2HttpOptions): Model = byActiveTabOrNull(options) ?: default()
}