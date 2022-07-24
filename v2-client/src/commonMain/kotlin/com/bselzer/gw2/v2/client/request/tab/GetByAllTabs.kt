package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetByAllTabs<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Gets the [Model]s using all tabs.
     */
    suspend fun byAllTabs(options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s using all tabs, or an empty list if unable to fulfill the request.
     */
    suspend fun byAllTabsOrEmpty(options: Gw2HttpOptions): List<Model>
}