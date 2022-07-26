package com.bselzer.gw2.v2.client.request.model

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions

interface GetModels<T> {
    /**
     * Gets the models.
     */
    suspend fun models(options: Gw2HttpOptions): List<T>

    /**
     * Gets the models, or an empty list if unable to fulfill the request.
     */
    suspend fun modelsOrEmpty(options: Gw2HttpOptions): List<T>
}