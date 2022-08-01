package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetByAllTabs<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Gets the [Model]s using all tabs, or a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byAllTabs(options: Gw2HttpOptions): Result<List<Model>>

    /**
     * Gets the [Model]s using all tabs, or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byAllTabsOrThrow(options: Gw2HttpOptions): List<Model>

    /**
     * Gets the [Model]s using all tabs, or an empty list if unable to fulfill the request.
     */
    suspend fun byAllTabsOrEmpty(options: Gw2HttpOptions): List<Model>
}