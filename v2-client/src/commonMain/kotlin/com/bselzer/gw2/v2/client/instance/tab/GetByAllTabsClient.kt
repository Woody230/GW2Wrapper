package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.instance.base.GetClient
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.tab.GetByAllTabs
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface GetByAllTabsClient<Model, Tab, Value> : GetClient, GetByAllTabs<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the [Model]s using all tabs.
     */
    suspend fun HttpClient.byAllTabs(
        options: Gw2HttpOptions,
    ): List<Model> = get(options) {
        parameter("tabs", "all")
    }.body()

    /**
     * Gets the [Model]s using all tabs, or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.byAllTabsOrEmpty(
        options: Gw2HttpOptions,
    ): List<Model> = try {
        byAllTabs(options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName} with all tabs." }
        emptyList()
    }
}