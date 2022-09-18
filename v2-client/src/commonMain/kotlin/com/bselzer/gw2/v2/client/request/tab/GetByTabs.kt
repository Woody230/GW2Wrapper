package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.options.Gw2RequestOptions
import com.bselzer.gw2.v2.client.result.AggregateGetResult
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetByTabs<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    /**
     * Requests are split into [Gw2RequestOptions.pageSize] size chunks, where each result is the following:
     *
     * Gets the [Model]s associated with the [tabs], or a [GetResult.Failure] if unable to fulfill the request.
     */
    suspend fun byTabs(tabs: Collection<Tab>, options: Gw2Options = Gw2Options.Default): AggregateGetResult<Model>

    /**
     * Requests are split into [Gw2RequestOptions.pageSize] size chunks.
     *
     * Gets the [Model]s associated with the [tabs], or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byTabsOrThrow(tabs: Collection<Tab>, options: Gw2Options = Gw2Options.Default): List<Model>

    /**
     * Requests are split into [Gw2RequestOptions.pageSize] size chunks.
     *
     * Gets the [Model]s associated with the [tabs], or an empty list if unable to fulfill the request.
     */
    suspend fun byTabsOrEmpty(tabs: Collection<Tab>, options: Gw2Options = Gw2Options.Default): List<Model>

    /**
     * Requests are split into [Gw2RequestOptions.pageSize] size chunks.
     *
     * Gets the [Model]s associated with the [tabs], or a defaulted [Model] with the [Tab] populated if it is missing from the response.
     */
    suspend fun byTabsOrDefault(tabs: Collection<Tab>, options: Gw2Options = Gw2Options.Default): List<Model>
}