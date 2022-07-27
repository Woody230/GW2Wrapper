package com.bselzer.gw2.v2.client.request.search

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions

interface GetByInput<Model, Input> {
    /**
     * Gets the [Model]s that require the given [input].
     */
    suspend fun byInput(input: Input, options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s that require the given [input], or an empty list if unable to fulfill the request.
     */
    suspend fun byInputOrEmpty(input: Input, options: Gw2HttpOptions): List<Model>
}