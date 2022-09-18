package com.bselzer.gw2.v2.client.instance.model

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceContext
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.request.model.GetModel
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.client.GenericTypeInfo
import com.bselzer.ktx.client.genericTypeInfo
import io.ktor.client.*
import io.ktor.client.request.*

class GetModelResource<Model> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetModel<Model> {
    private val context: () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}." }
    private val parameters: HttpRequestBuilder.() -> Unit = { }

    override suspend fun model(options: Gw2Options): GetResult<Model> = options.get(context, parameters)
    override suspend fun modelOrThrow(options: Gw2Options): Model = model(options).getOrThrow()
    override suspend fun modelOrNull(options: Gw2Options): Model? = model(options).getOrNull()
}

inline fun <reified Model> Gw2ResourceContext.getModelResource(
    options: Gw2ResourceOptions
): GetModelResource<Model> = GetModelResource(
    httpClient,
    options,
    genericTypeInfo()
)