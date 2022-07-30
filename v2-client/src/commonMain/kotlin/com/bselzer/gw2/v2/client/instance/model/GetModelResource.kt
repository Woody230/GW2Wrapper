package com.bselzer.gw2.v2.client.instance.model

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.model.GetModel
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

class GetModelResource<Model>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: TypeInfo,
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetModel<Model> where Model : Any {
    private val context: () -> String = { "Request for ${modelTypeInfo.type.simpleName}." }
    private val parameters: HttpRequestBuilder.() -> Unit = { }

    override suspend fun model(options: Gw2HttpOptions): Model = options.get(context, parameters)
    override suspend fun modelOrNull(options: Gw2HttpOptions): Model? = options.getOrNull(context, parameters)
}