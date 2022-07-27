package com.bselzer.gw2.v2.client.instance.search

import com.bselzer.gw2.v2.client.instance.base.GetClient
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.search.GetByInput
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface GetByInputClient<Model, Input> : GetClient, GetByInput<Model, Input> {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the [Model]s that require the given [input].
     */
    suspend fun HttpClient.byInput(
        input: Input,
        options: Gw2HttpOptions
    ): List<Model> = get(options) {
        parameter("input", input)
    }.body()

    /**
     * Gets the [Model]s that require the given [input], or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.byInputOrEmpty(
        input: Input,
        options: Gw2HttpOptions
    ): List<Model> = try {
        byInput(input, options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName}s with input ${input}." }
        emptyList()
    }
}