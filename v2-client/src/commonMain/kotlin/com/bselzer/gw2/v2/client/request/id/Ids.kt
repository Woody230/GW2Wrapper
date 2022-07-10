package com.bselzer.gw2.v2.client.request.id

import com.bselzer.gw2.v2.client.request.Gw2GetRequest
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*

interface Ids<Id> : Gw2GetRequest where Id : Identifier<*> {
    /**
     * Gets the [Id]s of the available models.
     */
    suspend fun HttpClient.ids(options: Gw2HttpOptions): List<Id> = get(options).body()
}