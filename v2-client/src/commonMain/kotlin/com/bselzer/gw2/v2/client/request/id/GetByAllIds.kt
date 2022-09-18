package com.bselzer.gw2.v2.client.request.id

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier

interface GetByAllIds<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    /**
     * Gets the [Model]s using all ids, or a [GetResult.Failure] if unable to fulfill the request.
     */
    suspend fun byAllIds(options: Gw2Options = Gw2Options.Default): GetResult<List<Model>>

    /**
     * Gets the [Model]s using all ids, or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byAllIdsOrThrow(options: Gw2Options = Gw2Options.Default): List<Model>

    /**
     * Gets the [Model]s using all ids, or an empty list if unable to fulfill the request.
     */
    suspend fun byAllIdsOrEmpty(options: Gw2Options = Gw2Options.Default): List<Model>
}