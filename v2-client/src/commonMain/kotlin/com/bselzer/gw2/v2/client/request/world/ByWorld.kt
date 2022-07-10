package com.bselzer.gw2.v2.client.request.world

import com.bselzer.gw2.v2.client.request.GetModel
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.gw2.v2.model.world.WorldId
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface ByWorld<Model> : GetModel {
    /**
     * Gets the [Model] associated with the world that has id [worldId].
     */
    suspend fun HttpClient.byWorld(
        worldId: WorldId,
        options: Gw2HttpOptions,
    ): Model = get(options) {
        parameter("world", worldId.value)
    }.body(modelTypeInfo)

    /**
     * Gets the [Model] associated with the world that has id [worldId], or null if unable to fulfill the request.
     */
    suspend fun HttpClient.byWorldOrNull(
        worldId: WorldId,
        options: Gw2HttpOptions
    ): Model? = try {
        byWorld(worldId, options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to request ${modelTypeInfo.type.simpleName} for the world with id $worldId." }
        null
    }
}