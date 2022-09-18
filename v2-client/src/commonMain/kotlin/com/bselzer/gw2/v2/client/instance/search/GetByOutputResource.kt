package com.bselzer.gw2.v2.client.instance.search

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceContext
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.request.search.GetByOutput
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.client.GenericTypeInfo
import com.bselzer.ktx.client.genericTypeInfo
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

    override suspend fun byOutput(output: Output, options: Gw2Options): GetResult<List<Model>> = options.get(output.context(), output.parameters())
    override suspend fun byOutputOrThrow(output: Output, options: Gw2Options): List<Model> = byOutput(output, options).getOrThrow()
    override suspend fun byOutputOrEmpty(output: Output, options: Gw2Options): List<Model> = byOutput(output, options).getOrNull() ?: emptyList()
}

inline fun <reified Model, Output> Gw2ResourceContext.getByOutputResource(
    options: Gw2ResourceOptions
): GetByOutputResource<Model, Output> = GetByOutputResource(
    httpClient,
    options,
    genericTypeInfo()
)