package com.bselzer.gw2.v2.client.request.model

import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface Models<T> : GetModel {
    /**
     * Gets the models.
     */
    suspend fun models(options: Gw2HttpOptions): List<T>

    /**
     * Gets the models, or an empty list if unable to fulfill the request.
     */
    suspend fun modelsOrEmpty(options: Gw2HttpOptions): List<T>

    /**
     * Gets the models.
     */
    suspend fun HttpClient.models(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<T> = get(options, customizations).body()

    /**
     * Gets the models, or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.modelsOrEmpty(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<T> = try {
        models(options, customizations)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName}s." }
        emptyList()
    }
}