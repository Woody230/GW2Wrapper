package com.bselzer.gw2.v2.client.instance.search

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.search.GetByInput
import io.ktor.client.*
import io.ktor.client.request.*

class GetByInputResource<Model, Input>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<List<Model>>(genericTypeInfo()), Gw2ResourceOptions by options, GetByInput<Model, Input> {
    private fun Input.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()}s with input $this." }
    private fun Input.parameters(): HttpRequestBuilder.() -> Unit = { parameter("input", this@parameters) }

    override suspend fun byInput(input: Input, options: Gw2HttpOptions): List<Model> = options.getOrThrow(input.context(), input.parameters())
    override suspend fun byInputOrEmpty(input: Input, options: Gw2HttpOptions): List<Model> = options.getOrNull(input.context(), input.parameters()) ?: emptyList()
}