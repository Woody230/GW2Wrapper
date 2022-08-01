package com.bselzer.gw2.v2.client.request.exchange

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions

interface GetByQuantity<Model, Quantity> {
    /**
     * Gets the [Model] associated with the [quantity], or a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byQuantity(quantity: Quantity, options: Gw2HttpOptions): Result<Model>

    /**
     * Gets the [Model] associated with the [quantity], or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byQuantityOrThrow(quantity: Quantity, options: Gw2HttpOptions): Model

    /**
     * Gets the [Model] associated with the [quantity], or null if unable to fulfill the request.
     */
    suspend fun byQuantityOrNull(quantity: Quantity, options: Gw2HttpOptions): Model?
}