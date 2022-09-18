package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.value.identifier.Identifier

interface GetTabs<Tab> where Tab : Identifier<*> {
    /**
     * Gets the [Tab]s of the available models, or a [GetResult.Failure] if unable to fulfill the request.
     */
    suspend fun tabs(options: Gw2Options = Gw2Options.Default): GetResult<List<Tab>>

    /**
     * Gets the [Tab]s of the available models, or throw a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun tabsOrThrow(options: Gw2Options = Gw2Options.Default): List<Tab>

    /**
     * Gets the [tabsOrThrow]s of the available models, or an empty list if unable to fulfill the request.
     */
    suspend fun tabsOrEmpty(options: Gw2Options = Gw2Options.Default): List<Tab>
}