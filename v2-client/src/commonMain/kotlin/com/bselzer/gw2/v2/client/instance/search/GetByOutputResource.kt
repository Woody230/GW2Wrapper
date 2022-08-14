package com.bselzer.gw2.v2.client.instance.search

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.search.GetByOutput
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*

class GetByOutputResource<Model, Output> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<List<Model>>(genericTypeInfo()), Gw2ResourceOptions by options, GetByOutput<Model, Output> {
    private fun Output.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}s with output $this." }
    private fun Output.parameters(): HttpRequestBuilder.() -> Unit = { parameter("output", this@parameters) }

    override suspend fun byOutput(output: Output, options: Gw2HttpOptions): Result<List<Model>> = options.get(output.context(), output.parameters())
    override suspend fun byOutputOrThrow(output: Output, options: Gw2HttpOptions): List<Model> = byOutput(output, options).getOrThrow()
    override suspend fun byOutputOrEmpty(output: Output, options: Gw2HttpOptions): List<Model> = byOutput(output, options).getOrNull() ?: emptyList()
}

inline fun <reified Model, Output> ResourceDependencies.getByOutputResource(
    options: Gw2ResourceOptions
): GetByOutputResource<Model, Output> = GetByOutputResource(
    httpClient,
    options,
    genericTypeInfo()
)