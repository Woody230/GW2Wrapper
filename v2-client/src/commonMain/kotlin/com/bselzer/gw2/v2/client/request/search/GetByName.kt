package com.bselzer.gw2.v2.client.request.search

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.result.GetResult

interface GetByName<Model> {
    /**
     * Gets the [Model]s with the given [name], or a [GetResult.Failure] if unable to fulfill the request.
     */
    suspend fun byName(name: String, options: Gw2Options = Gw2Options.Default): GetResult<List<Model>>

    /**
     * Gets the [Model]s with the given [name], or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byNameOrThrow(name: String, options: Gw2Options = Gw2Options.Default): List<Model>

    /**
     * Gets the [Model]s with the given [name], or an empty list if unable to fulfill the request.
     */
    suspend fun byNameOrEmpty(name: String, options: Gw2Options = Gw2Options.Default): List<Model>
}