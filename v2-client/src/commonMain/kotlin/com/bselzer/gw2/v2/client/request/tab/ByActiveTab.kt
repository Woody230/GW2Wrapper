package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.request.GetModel
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.http.*

interface ByActiveTab<Tab, Value, Model> : GetModel where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    /**
     * Gets the [Model] associated with the active tab.
     */
    suspend fun HttpClient.byTab(
        options: Gw2HttpOptions,
    ): Model = get(options) {
        url { appendPathSegments("active") }
    }.body(modelTypeInfo)

    /**
     * Gets the [Model] associated with the active tab, or null if unable to fulfill the request.
     */
    suspend fun HttpClient.byActiveTabOrNull(
        options: Gw2HttpOptions
    ): Model? = try {
        byTab(options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName} with the active tab." }
        null
    }

    /**
     * Gets the [Model] associated with the active tab, or the [default] model if unable to fulfill the request.
     */
    suspend fun HttpClient.byActiveTabOrDefault(
        options: Gw2HttpOptions,
        default: () -> Model
    ): Model = byActiveTabOrNull(options) ?: default()
}