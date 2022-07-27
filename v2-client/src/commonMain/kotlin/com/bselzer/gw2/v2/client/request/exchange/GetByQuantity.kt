package com.bselzer.gw2.v2.client.request.exchange

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions

interface GetByQuantity<Model, Quantity> {
    /**
     * Gets the [Model] associated with the [quantity].
     */
    suspend fun byQuantity(quantity: Quantity, options: Gw2HttpOptions): Model

    /**
     * Gets the [Model] associated with the [quantity], or null if unable to fulfill the request.
     */
    suspend fun byQuantityOrNull(quantity: Quantity, options: Gw2HttpOptions): Model?
}