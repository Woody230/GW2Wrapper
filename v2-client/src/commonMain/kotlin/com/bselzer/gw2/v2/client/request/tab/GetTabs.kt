package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifier

interface GetTabs<Tab> where Tab : Identifier<*> {
    /**
     * Gets the [Tab]s of the available models.
     */
    suspend fun tabs(options: Gw2HttpOptions): List<Tab>

    /**
     * Gets the [tabs]s of the available models, or an empty list if unable to fulfill the request.
     */
    suspend fun tabsOrEmpty(options: Gw2HttpOptions): List<Tab>
}