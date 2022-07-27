package com.bselzer.gw2.v2.client.request.model

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions

interface GetModel<Model> {
    /**
     * Gets the [Model].
     */
    suspend fun model(options: Gw2HttpOptions): Model

    /**
     * Gets the [Model], or null if unable to fulfill the request.
     */
    suspend fun modelOrNull(options: Gw2HttpOptions): Model?
}