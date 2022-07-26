package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.instance.base.GetClient
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.tab.GetByActiveTab
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.reflect.*

interface GetByActiveTabClient<Model, Tab, Value> : GetClient, GetByActiveTab<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the [Model] associated with the active tab.
     */
    suspend fun HttpClient.byActiveTab(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): Model = get(options) {
        url { appendPathSegments("active") }
        apply(customizations)
    }.body(modelTypeInfo)

    /**
     * Gets the [Model] associated with the active tab, or null if unable to fulfill the request.
     */
    suspend fun HttpClient.byActiveTabOrNull(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): Model? = try {
        byActiveTab(options, customizations)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName} with the active tab." }
        null
    }

    /**
     * Gets the [Model] associated with the active tab, or the [default] model if unable to fulfill the request.
     */
    suspend fun HttpClient.byActiveTabOrDefault(
        default: () -> Model,
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): Model = byActiveTabOrNull(options, customizations) ?: default()
}