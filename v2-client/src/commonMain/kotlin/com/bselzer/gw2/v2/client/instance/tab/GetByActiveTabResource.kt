package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.tab.GetByActiveTab
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.client.GenericTypeInfo
import com.bselzer.ktx.client.genericTypeInfo
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class GetByActiveTabResource<Model, Tab, Value> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetByActiveTab<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    private val context: () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} associated with the active tab." }
    private val parameters: HttpRequestBuilder.() -> Unit = {
        url { appendPathSegments("active") }
    }

    override suspend fun byActiveTab(options: Gw2HttpOptions): GetResult<Model> = options.get(context, parameters)
    override suspend fun byActiveTabOrThrow(options: Gw2HttpOptions): Model = byActiveTab(options).getOrThrow()
    override suspend fun byActiveTabOrNull(options: Gw2HttpOptions): Model? = byActiveTab(options).getOrNull()
}

inline fun <reified Model, Tab, Value> ResourceDependencies.getByActiveTabResource(
    options: Gw2ResourceOptions
): GetByActiveTabResource<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> =
    GetByActiveTabResource(
        httpClient,
        options,
        genericTypeInfo()
    )