package com.bselzer.gw2.v2.client.request.search

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions

interface GetByName<Model> {
    /**
     * Gets the [Model]s with the given [name].
     */
    suspend fun byName(name: String, options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s with the given [name], or an empty list if unable to fulfill the request.
     */
    suspend fun byNameOrEmpty(name: String, options: Gw2HttpOptions): List<Model>
}