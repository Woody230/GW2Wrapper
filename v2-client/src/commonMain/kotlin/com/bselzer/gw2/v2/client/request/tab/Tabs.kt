package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.request.Gw2GetRequest
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*

interface Tabs<Tab> : Gw2GetRequest where Tab : Identifier<*> {
    /**
     * Gets the [Tab]s of the available models.
     */
    suspend fun HttpClient.tabs(options: Gw2HttpOptions): List<Tab> = get(options).body()
}