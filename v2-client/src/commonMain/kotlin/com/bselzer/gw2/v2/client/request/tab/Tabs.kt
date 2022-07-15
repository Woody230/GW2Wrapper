package com.bselzer.gw2.v2.client.request.tab

import com.bselzer.gw2.v2.client.request.Gw2GetRequest
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.util.reflect.*

interface Tabs<Tab> : Gw2GetRequest where Tab : Identifier<*> {
    val tabTypeInfo: TypeInfo

    /**
     * Gets the [Tab]s of the available models.
     */
    suspend fun HttpClient.tabs(options: Gw2HttpOptions): List<Tab> = get(options).body()

    /**
     * Gets the [Tabs]s of the available models, or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.tabsOrEmpty(options: Gw2HttpOptions): List<Tab> = try {
        tabs(options)
    } catch (ex: Exception) {

        Logger.e(ex) { "Failed to request ${tabTypeInfo.type.simpleName}s." }
        emptyList()
    }
}