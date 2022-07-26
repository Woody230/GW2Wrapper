package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetByTabs<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    /**
     * Gets the [Model]s associated with the [tabs].
     */
    suspend fun byTabs(tabs: Collection<Tab>, options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s associated with the [tabs], or an empty list if unable to fulfill the request.
     */
    suspend fun byTabsOrEmpty(tabs: Collection<Tab>, options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s associated with the [tabs], or a [default] model if it is missing from the response.
     */
    suspend fun byTabsOrDefault(tabs: Collection<Tab>, default: (Tab) -> Model, options: Gw2HttpOptions): List<Model>
}