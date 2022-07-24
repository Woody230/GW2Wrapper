package com.bselzer.gw2.v2.client.request.id

import com.bselzer.gw2.v2.client.request.model.GetModel
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface ByAllIds<Id, Value, Model> : GetModel where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Gets the [Model]s using all ids.
     */
    suspend fun byAllIds(options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s using all ids, or an empty list if unable to fulfill the request.
     */
    suspend fun byAllIdsOrEmpty(options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s using all ids.
     */
    suspend fun HttpClient.byAllIds(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Model> = get(options) {
        parameter("ids", "all")
        apply(customizations)
    }.body()

    /**
     * Gets the [Model]s using all ids, or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.byAllIdsOrEmpty(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Model> = try {
        byAllIds(options, customizations)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName} with all ids." }
        emptyList()
    }
}