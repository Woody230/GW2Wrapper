package com.bselzer.gw2.v2.client.instance.model

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.model.GetModels
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

class GetModelsResource<Model>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: TypeInfo,
) : GetResource<List<Model>>(typeInfo<List<Model>>()), Gw2ResourceOptions by options, GetModels<Model> where Model : Any {
    private val context: () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}s." }
    private val parameters: HttpRequestBuilder.() -> Unit = { }

    override suspend fun models(options: Gw2HttpOptions): List<Model> = options.get(context, parameters)
    override suspend fun modelsOrEmpty(options: Gw2HttpOptions): List<Model> = options.getOrNull(context, parameters) ?: emptyList()
}