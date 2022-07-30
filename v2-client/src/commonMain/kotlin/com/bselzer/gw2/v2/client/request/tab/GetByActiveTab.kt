package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetByActiveTab<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    /**
     * Gets the [Model] associated with the active tab.
     */
    suspend fun byActiveTab(options: Gw2HttpOptions): Model

    /**
     * Gets the [Model] associated with the active tab, or null if unable to fulfill the request.
     */
    suspend fun byActiveTabOrNull(options: Gw2HttpOptions): Model?
}