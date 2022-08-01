package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetByActiveTab<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    /**
     * Gets the [Model] associated with the active tab, or a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byActiveTab(options: Gw2HttpOptions): Result<Model>

    /**
     * Gets the [Model] associated with the active tab, or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byActiveTabOrThrow(options: Gw2HttpOptions): Model

    /**
     * Gets the [Model] associated with the active tab, or null if unable to fulfill the request.
     */
    suspend fun byActiveTabOrNull(options: Gw2HttpOptions): Model?
}