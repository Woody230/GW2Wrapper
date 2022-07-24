package com.bselzer.gw2.v2.client.request.model

import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface Model<T> : GetModel {
    /**
     * Gets the model.
     */
    suspend fun model(options: Gw2HttpOptions): T

    /**
     * Gets the model, or null if unable to fulfill the request.
     */
    suspend fun modelOrNull(options: Gw2HttpOptions): T?

    /**
     * Gets the model.
     */
    suspend fun HttpClient.model(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): T = get(options, customizations).body(modelTypeInfo)

    /**
     * Gets the model, or null if unable to fulfill the request.
     */
    suspend fun HttpClient.modelOrNull(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): T? = try {
        model(options, customizations)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName}." }
        null
    }
}