package com.bselzer.gw2.v2.client.instance.model

import com.bselzer.gw2.v2.client.instance.base.GetClient
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.model.GetModels
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.util.reflect.*

interface GetModelsClient<Model> : GetClient, GetModels<Model> where Model : Any {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the models.
     */
    suspend fun HttpClient.models(
        options: Gw2HttpOptions,
    ): List<Model> = get(options).body()

    /**
     * Gets the models, or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.modelsOrEmpty(
        options: Gw2HttpOptions,
    ): List<Model> = try {
        models(options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName}s." }
        emptyList()
    }
}