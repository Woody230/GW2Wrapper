package com.bselzer.gw2.v2.client.request.tabs

import com.bselzer.gw2.v2.client.request.GetModel
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
    suspend fun HttpClient.byTab(
        tab: Tab,
        options: Gw2HttpOptions,
    ): Model = get(options) {
        parameter("tab", tab.value)
    }.body(modelTypeInfo)

    /**
     * Gets the [Model] associated with the [tab], or null if unable to fulfill the request.
     */
    suspend fun HttpClient.byTabOrNull(
        tab: Tab,
        options: Gw2HttpOptions
    ): Model? = try {
        byTab(tab, options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName} with tab $tab." }
        null
    }

    /**
     * Gets the [Model] associated with the [tab], or the [default] model if unable to fulfill the request.
     */
    suspend fun HttpClient.byTabOrDefault(
        tab: Tab,
        options: Gw2HttpOptions,
        default: (Tab) -> Model
    ): Model = byTabOrNull(tab, options) ?: default(tab)
}