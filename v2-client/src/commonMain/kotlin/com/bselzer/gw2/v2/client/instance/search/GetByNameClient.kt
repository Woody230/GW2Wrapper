package com.bselzer.gw2.v2.client.instance.search

import com.bselzer.gw2.v2.client.instance.base.GetClient
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.search.GetByName
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface GetByNameClient<Model> : GetClient, GetByName<Model> {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the [Model]s with the given [name].
     */
    suspend fun HttpClient.byName(
        name: String,
        options: Gw2HttpOptions
    ): List<Model> = get(options) {
        parameter("name", name)
    }.body()

    /**
     * Gets the [Model]s with the given [name], or an empty list if unable to fulfill the request.
     */
    suspend fun HttpClient.byNameOrEmpty(
        name: String,
        options: Gw2HttpOptions
    ): List<Model> = try {
        byName(name, options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName}s with name ${name}." }
        emptyList()
    }
}