package com.bselzer.gw2.v2.client.request.id

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifier

interface GetIds<Id> where Id : Identifier<*> {
    /**
     * Gets the [Id]s of the available models, or a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun ids(options: Gw2HttpOptions): Result<List<Id>>

    /**
     * Gets the [Id]s of the available models, or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun idsOrThrow(options: Gw2HttpOptions): List<Id>

    /**
     * Gets the [Id]s of the available models, or an empty list if unable to fulfill the request.
     */
    suspend fun idsOrEmpty(options: Gw2HttpOptions): List<Id>
}