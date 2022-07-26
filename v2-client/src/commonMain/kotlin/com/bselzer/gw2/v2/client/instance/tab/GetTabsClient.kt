package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.instance.base.GetClient
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.tab.GetTabs
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface GetTabsClient<Tab> : GetClient, GetTabs<Tab> where Tab : Identifier<*> {
    val tabTypeInfo: TypeInfo

    /**
     * Gets the [Tab]s of the available models.
     */
    suspend fun HttpClient.tabs(
        options: Gw2HttpOptions,
    ): List<Tab> = get(options).body()

    /**
     * Gets the [tabs]s of the available models, or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.tabsOrEmpty(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Tab> = try {
        tabs(options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${tabTypeInfo.type.simpleName}s." }
        emptyList()
    }
}