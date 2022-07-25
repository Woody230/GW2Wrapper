package com.bselzer.gw2.v2.client.request.client.id

import com.bselzer.gw2.v2.client.request.client.GetClient
import com.bselzer.gw2.v2.client.request.id.GetByAllIds
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface GetByAllIdsClient<Model, Id, Value> : GetClient, GetByAllIds<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the [Model]s using all ids.
     */
    suspend fun HttpClient.byAllIds(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Model> = get(options) {
        parameter("ids", "all")
        apply(customizations)
    }.body()

    /**
     * Gets the [Model]s using all ids, or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.byAllIdsOrEmpty(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Model> = try {
        byAllIds(options, customizations)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName} with all ids." }
        emptyList()
    }
}