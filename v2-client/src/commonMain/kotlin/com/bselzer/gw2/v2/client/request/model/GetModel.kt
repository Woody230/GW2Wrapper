package com.bselzer.gw2.v2.client.request.model

import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions

interface GetModel<T> {
    /**
     * Gets the model.
     */
    suspend fun model(options: Gw2HttpOptions): T

    /**
     * Gets the model, or null if unable to fulfill the request.
     */
    suspend fun modelOrNull(options: Gw2HttpOptions): T?
}