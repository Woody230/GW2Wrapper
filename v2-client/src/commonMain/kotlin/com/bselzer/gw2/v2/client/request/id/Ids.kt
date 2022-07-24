package com.bselzer.gw2.v2.client.request.id

import com.bselzer.gw2.v2.client.request.Gw2GetRequest
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.ktx.logging.Logger
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface Ids<Id> : Gw2GetRequest where Id : Identifier<*> {
    val idTypeInfo: TypeInfo

    /**
     * Gets the [Id]s of the available models.
     */
    suspend fun ids(options: Gw2HttpOptions): List<Id>

    /**
     * Gets the [Id]s of the available models, or an empty list if unable to fulfill the request.
     */
    suspend fun idsOrEmpty(options: Gw2HttpOptions): List<Id>

    /**
     * Gets the [Id]s of the available models.
     */
    suspend fun HttpClient.ids(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Id> = get(options, customizations).body()

    /**
     * Gets the [Id]s of the available models, or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.idsOrEmpty(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): List<Id> = try {
        ids(options, customizations)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${idTypeInfo.type.simpleName}s." }
        emptyList()
    }
}