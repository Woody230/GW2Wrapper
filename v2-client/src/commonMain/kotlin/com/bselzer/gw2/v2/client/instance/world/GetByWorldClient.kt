package com.bselzer.gw2.v2.client.instance.world

import com.bselzer.gw2.v2.client.instance.base.GetClient
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.world.GetByWorld
import com.bselzer.gw2.v2.model.world.WorldId
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

interface GetByWorldClient<Model> : GetClient, GetByWorld<Model> {
    val modelTypeInfo: TypeInfo

    /**
     * Gets the [Model] associated with the world that has id [worldId].
     */
    suspend fun HttpClient.byWorld(
        worldId: WorldId,
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): Model = get(options) {
        parameter("world", worldId.value)
        apply(customizations)
    }.body(modelTypeInfo)

    /**
     * Gets the [Model] associated with the world that has id [worldId], or null if unable to fulfill the request.
     */
    suspend fun HttpClient.byWorldOrNull(
        worldId: WorldId,
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): Model? = try {
        byWorld(worldId, options, customizations)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName} for the world with id $worldId." }
        null
    }
}