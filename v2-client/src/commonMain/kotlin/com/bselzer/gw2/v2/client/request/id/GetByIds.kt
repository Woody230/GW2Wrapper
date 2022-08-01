package com.bselzer.gw2.v2.client.request.id

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.instance.base.AggregateListResult
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetByIds<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Requests are split into [Gw2HttpOptions.pageSize] size chunks, where each result is the following:
     *
     * Gets the [Model]s associated with the [ids], or a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byIds(ids: Collection<Id>, options: Gw2HttpOptions): AggregateListResult<Model>

    /**
     * Requests are split into [Gw2HttpOptions.pageSize] size chunks.
     *
     * Gets the [Model]s associated with the [ids], or throws a [Gw2ClientException] if unable to fulfill any request.
     */
    suspend fun byIdsOrThrow(ids: Collection<Id>, options: Gw2HttpOptions): List<Model>

    /**
     * Requests are split into [Gw2HttpOptions.pageSize] size chunks.
     *
     * Gets the [Model]s associated with the [ids]. Requests that cannot be fulfilled are consolidated as an empty list.
     */
    suspend fun byIdsOrEmpty(ids: Collection<Id>, options: Gw2HttpOptions): List<Model>

    /**
     * Requests are split into [Gw2HttpOptions.pageSize] size chunks.
     *
     * Gets the [Model]s associated with the [ids], or a defaulted [Model] with the [Id] populated if it is missing from the response.
     */
    suspend fun byIdsOrDefault(ids: Collection<Id>, options: Gw2HttpOptions): List<Model>
}