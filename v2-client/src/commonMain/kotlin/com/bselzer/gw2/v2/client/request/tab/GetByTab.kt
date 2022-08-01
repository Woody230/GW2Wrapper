package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetByTab<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    /**
     * Gets the [Model] associated with the [tab], or a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byTab(tab: Tab, options: Gw2HttpOptions): Result<Model>

    /**
     * Gets the [Model] associated with the [tab], or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byTabOrThrow(tab: Tab, options: Gw2HttpOptions): Model

    /**
     * Gets the [Model] associated with the [tab], or null if unable to fulfill the request.
     */
    suspend fun byTabOrNull(tab: Tab, options: Gw2HttpOptions): Model?

    /**
     * Gets the [Model] associated with the [tab], or a defaulted [Model] with the [Tab] populated if unable to fulfill the request.
     */
    suspend fun byTabOrDefault(tab: Tab, options: Gw2HttpOptions): Model
}