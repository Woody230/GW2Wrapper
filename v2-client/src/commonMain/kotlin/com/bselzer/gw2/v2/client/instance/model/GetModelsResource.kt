package com.bselzer.gw2.v2.client.instance.model

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.model.GetModels
import io.ktor.client.*
import io.ktor.client.request.*

class GetModelsResource<Model> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<List<Model>>(genericTypeInfo()), Gw2ResourceOptions by options, GetModels<Model> {
    private val context: () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}s." }
    private val parameters: HttpRequestBuilder.() -> Unit = { }

    override suspend fun models(options: Gw2HttpOptions): Result<List<Model>> = options.get(context, parameters)
    override suspend fun modelsOrThrow(options: Gw2HttpOptions): List<Model> = models(options).getOrThrow()
    override suspend fun modelsOrEmpty(options: Gw2HttpOptions): List<Model> = models(options).getOrNull() ?: emptyList()
}

inline fun <reified Model> ResourceDependencies.getModelsResource(
    options: Gw2ResourceOptions
): GetModelsResource<Model> = GetModelsResource(
    httpClient,
    options,
    genericTypeInfo()
)