package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.request.model.GetModel
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface ByTab<Tab, Value, Model> : GetModel where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    /**
     * Gets the [Model] associated with the [tab].
     */
    suspend fun byTab(tab: Tab, options: Gw2HttpOptions): Model

    /**
     * Gets the [Model] associated with the [tab], or null if unable to fulfill the request.
     */
    suspend fun byTabOrNull(tab: Tab, options: Gw2HttpOptions): Model?

    /**
     * Gets the [Model] associated with the [tab], or the [default] model if unable to fulfill the request.
     */
    suspend fun byTabOrDefault(tab: Tab, default: (Tab) -> Model, options: Gw2HttpOptions): Model

    /**
     * Gets the [Model] associated with the [tab].
     */
    suspend fun HttpClient.byTab(
        tab: Tab,
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): Model = get(options) {
        parameter("tab", tab.value)
        apply(customizations)
    }.body(modelTypeInfo)

    /**
     * Gets the [Model] associated with the [tab], or null if unable to fulfill the request.
     */
    suspend fun HttpClient.byTabOrNull(
        tab: Tab,
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): Model? = try {
        byTab(tab, options, customizations)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName} with tab $tab." }
        null
    }

    /**
     * Gets the [Model] associated with the [tab], or the [default] model if unable to fulfill the request.
     */
    suspend fun HttpClient.byTabOrDefault(
        tab: Tab,
        default: (Tab) -> Model,
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): Model = byTabOrNull(tab, options, customizations) ?: default(tab)
}