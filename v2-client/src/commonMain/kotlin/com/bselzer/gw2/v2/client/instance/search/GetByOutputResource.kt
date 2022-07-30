package com.bselzer.gw2.v2.client.instance.search

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.search.GetByOutput
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*
import io.ktor.utils.io.core.*

class GetByOutputResource<Model, Output>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: TypeInfo,
) : GetResource<List<Model>>(typeInfo<List<Model>>()), Gw2ResourceOptions by options, GetByOutput<Model, Output> {
    private fun Output.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}s with output $this." }
    private fun Output.parameters(): HttpRequestBuilder.() -> Unit = { parameter("output", this@parameters) }

    override suspend fun byOutput(output: Output, options: Gw2HttpOptions): List<Model> = options.get(output.context(), output.parameters())
    override suspend fun byOutputOrEmpty(output: Output, options: Gw2HttpOptions): List<Model> = options.getOrNull(output.context(), output.parameters()) ?: emptyList()
}