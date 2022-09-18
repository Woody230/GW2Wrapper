package com.bselzer.gw2.v2.client.request.search

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.result.GetResult

interface GetByOutput<Model, Output> {
    /**
     * Gets the [Model]s that produce the given [output], or a [GetResult.Failure] if unable to fulfill the request.
     */
    suspend fun byOutput(output: Output, options: Gw2Options = Gw2Options.Default): GetResult<List<Model>>

    /**
     * Gets the [Model]s that produce the given [output], or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byOutputOrThrow(output: Output, options: Gw2Options = Gw2Options.Default): List<Model>

    /**
     * Gets the [Model]s that produce the given [output], or an empty list if unable to fulfill the request.
     */
    suspend fun byOutputOrEmpty(output: Output, options: Gw2Options = Gw2Options.Default): List<Model>
}