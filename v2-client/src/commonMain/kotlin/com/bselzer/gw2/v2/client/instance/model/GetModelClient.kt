package com.bselzer.gw2.v2.client.instance.model

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.client.GetClient
import com.bselzer.gw2.v2.client.request.model.GetModel
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface GetModelClient<Model> : GetClient, GetModel<Model> where Model : Any {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the model.
     */
    suspend fun HttpClient.model(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): Model = get(options, customizations).body(modelTypeInfo)

    /**
     * Gets the model, or null if unable to fulfill the request.
     */
    suspend fun HttpClient.modelOrNull(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): Model? = try {
        model(options, customizations)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName}." }
        null
    }
}