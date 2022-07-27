package com.bselzer.gw2.v2.client.instance.search

import com.bselzer.gw2.v2.client.instance.base.GetClient
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.search.GetByOutput
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface GetByOutputClient<Model, Output> : GetClient, GetByOutput<Model, Output> {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the [Model]s that produce the given [output].
     */
    suspend fun HttpClient.byOutput(
        output: Output,
        options: Gw2HttpOptions
    ): List<Model> = get(options) {
        parameter("output", output)
    }.body()

    /**
     * Gets the [Model]s that produce the given [output], or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.byOutputOrEmpty(
        output: Output,
        options: Gw2HttpOptions
    ): List<Model> = try {
        byOutput(output, options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName}s with output ${output}." }
        emptyList()
    }
}