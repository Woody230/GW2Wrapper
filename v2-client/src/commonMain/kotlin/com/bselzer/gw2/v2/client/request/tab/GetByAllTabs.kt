package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetByAllTabs<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Gets the [Model]s using all tabs, or a [GetResult.Failure] if unable to fulfill the request.
     */
    suspend fun byAllTabs(options: Gw2Options = Gw2Options.Default): GetResult<List<Model>>

    /**
     * Gets the [Model]s using all tabs, or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byAllTabsOrThrow(options: Gw2Options = Gw2Options.Default): List<Model>

    /**
     * Gets the [Model]s using all tabs, or an empty list if unable to fulfill the request.
     */
    suspend fun byAllTabsOrEmpty(options: Gw2Options = Gw2Options.Default): List<Model>
}