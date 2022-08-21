package com.bselzer.gw2.v2.client.instance.model

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.model.GetModel
import com.bselzer.gw2.v2.client.result.GetResult
import io.ktor.client.*
import io.ktor.client.request.*

open class GetModelResource<Model> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetModel<Model> {
    private val context: () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}." }
    private val parameters: HttpRequestBuilder.() -> Unit = { }

    override suspend fun model(options: Gw2HttpOptions): GetResult<Model> = options.get(context, parameters)
    override suspend fun modelOrThrow(options: Gw2HttpOptions): Model = model(options).getOrThrow()
    override suspend fun modelOrNull(options: Gw2HttpOptions): Model? = model(options).getOrNull()
}

inline fun <reified Model> ResourceDependencies.getModelResource(
    options: Gw2ResourceOptions
): GetModelResource<Model> = GetModelResource(
    httpClient,
    options,
    genericTypeInfo()
)