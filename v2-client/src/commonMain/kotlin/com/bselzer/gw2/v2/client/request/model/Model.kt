package com.bselzer.gw2.v2.client.request.model

import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*

interface Model<T> : GetModel {
    /**
     * Gets the model.
     */
    suspend fun HttpClient.model(options: Gw2HttpOptions): T = get(options).body(modelTypeInfo)

    /**
     * Gets the model, or null if unable to fulfill the request.
     */
    suspend fun HttpClient.modelOrNull(options: Gw2HttpOptions): T? = try {
        model(options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName}." }
        null
    }
}