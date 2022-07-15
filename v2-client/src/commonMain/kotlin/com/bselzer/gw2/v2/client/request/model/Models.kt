package com.bselzer.gw2.v2.client.request.model

import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*

interface Models<T> : GetModel {
    /**
     * Gets the models.
     */
    suspend fun HttpClient.models(options: Gw2HttpOptions): List<T> = get(options).body()

    /**
     * Gets the models, or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.modelsOrEmpty(options: Gw2HttpOptions): List<T> = try {
        models(options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName}s." }
        emptyList()
    }
}