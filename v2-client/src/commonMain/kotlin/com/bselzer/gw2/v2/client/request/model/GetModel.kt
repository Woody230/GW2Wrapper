package com.bselzer.gw2.v2.client.request.model

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.result.GetResult

interface GetModel<Model> {
    /**
     * Gets the [Model], or a [GetResult.Failure] if unable to fulfill the request.
     */
    suspend fun model(options: Gw2Options = Gw2Options.Default): GetResult<Model>

    /**
     * Gets the [Model], or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun modelOrThrow(options: Gw2Options = Gw2Options.Default): Model

    /**
     * Gets the [Model], or null if unable to fulfill the request.
     */
    suspend fun modelOrNull(options: Gw2Options = Gw2Options.Default): Model?
}