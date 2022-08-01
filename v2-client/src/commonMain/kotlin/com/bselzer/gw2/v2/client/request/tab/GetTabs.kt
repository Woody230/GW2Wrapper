package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifier

interface GetTabs<Tab> where Tab : Identifier<*> {
    /**
     * Gets the [Tab]s of the available models, or a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun tabs(options: Gw2HttpOptions): Result<List<Tab>>

    /**
     * Gets the [Tab]s of the available models, or throw a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun tabsOrThrow(options: Gw2HttpOptions): List<Tab>

    /**
     * Gets the [tabsOrThrow]s of the available models, or an empty list if unable to fulfill the request.
     */
    suspend fun tabsOrEmpty(options: Gw2HttpOptions): List<Tab>
}