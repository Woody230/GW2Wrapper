package com.bselzer.gw2.v2.client.request.client.tab

import com.bselzer.gw2.v2.client.request.client.GetClient
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.tab.GetByTabs
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface GetByTabsClient<Model, Tab, Value> : GetClient, GetByTabs<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the [Model]s associated with the [tabs].
     */
    suspend fun HttpClient.byIds(
        tabs: Collection<Tab>,
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Model> {
        val chunks = tabs.chunked(options.coercedPageSize()).filter { chunk -> chunk.isNotEmpty() }
        return chunks.flatMap { chunk ->
            get(options) {
                parameter("tabs", chunk.joinToString(separator = ","))
                apply(customizations)
            }.body<List<Model>>()
        }
    }

    /**
     * Gets the [Model]s associated with the [tabs], or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.byIdsOrEmpty(
        tabs: Collection<Tab>,
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Model> = try {
        byIds(tabs, options, customizations)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName} with ids ${tabs.joinToString()}." }
        emptyList()
    }

    /**
     * Gets the [Model]s associated with the [tabs], or a [default] model if it is missing from the response.
     */
    suspend fun HttpClient.byIdsOrDefault(
        tabs: Collection<Tab>,
        default: (Tab) -> Model,
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Model> {
        val models = byIdsOrEmpty(tabs, options, customizations).associateBy { model -> model.id }
        return tabs.map { id -> models[id] ?: default(id) }
    }
}