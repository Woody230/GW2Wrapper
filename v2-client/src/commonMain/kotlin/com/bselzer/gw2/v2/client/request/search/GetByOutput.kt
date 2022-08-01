package com.bselzer.gw2.v2.client.request.search

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions

interface GetByOutput<Model, Output> {
    /**
     * Gets the [Model]s that produce the given [output], or a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byOutput(output: Output, options: Gw2HttpOptions): Result<List<Model>>

    /**
     * Gets the [Model]s that produce the given [output], or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byOutputOrThrow(output: Output, options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s that produce the given [output], or an empty list if unable to fulfill the request.
     */
    suspend fun byOutputOrEmpty(output: Output, options: Gw2HttpOptions): List<Model>
}