package com.bselzer.gw2.v2.client.request.search

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.result.GetResult

interface GetByInput<Model, Input> {
    /**
     * Gets the [Model]s that require the given [input], or a [GetResult.Failure] if unable to fulfill the request.
     */
    suspend fun byInput(input: Input, options: Gw2HttpOptions): GetResult<List<Model>>

    /**
     * Gets the [Model]s that require the given [input], or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byInputOrThrow(input: Input, options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s that require the given [input], or an empty list if unable to fulfill the request.
     */
    suspend fun byInputOrEmpty(input: Input, options: Gw2HttpOptions): List<Model>
}