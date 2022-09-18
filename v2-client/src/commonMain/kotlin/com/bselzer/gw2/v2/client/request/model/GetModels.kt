package com.bselzer.gw2.v2.client.request.model

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.result.GetResult

interface GetModels<Model> {
    /**
     * Gets the [Model]s, or a [GetResult.Failure] if unable to fulfill the request.
     */
    suspend fun models(options: Gw2Options = Gw2Options.Default): GetResult<List<Model>>

    /**
     * Gets the [Model]s, or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun modelsOrThrow(options: Gw2Options = Gw2Options.Default): List<Model>

    /**
     * Gets the [Model]s, or an empty list if unable to fulfill the request.
     */
    suspend fun modelsOrEmpty(options: Gw2Options = Gw2Options.Default): List<Model>
}