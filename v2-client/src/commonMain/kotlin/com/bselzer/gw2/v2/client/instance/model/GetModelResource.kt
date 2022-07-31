package com.bselzer.gw2.v2.client.instance.model

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.model.GetModel
import io.ktor.client.*
import io.ktor.client.request.*

class GetModelResource<Model> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetModel<Model> {
    private val context: () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}." }
    private val parameters: HttpRequestBuilder.() -> Unit = { }

    override suspend fun model(options: Gw2HttpOptions): Model = options.getOrThrow(context, parameters)
    override suspend fun modelOrNull(options: Gw2HttpOptions): Model? = options.getOrNull(context, parameters)
}

inline fun <reified Model> getModelResource(
    httpClient: HttpClient,
    options: Gw2ResourceOptions
): GetModelResource<Model> = GetModelResource(httpClient, options, genericTypeInfo())