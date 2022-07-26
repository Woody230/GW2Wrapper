package com.bselzer.gw2.v2.client.request.world

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.model.world.WorldId

interface GetByWorld<Model> {
    /**
     * Gets the [Model] associated with the world that has id [worldId].
     */
    suspend fun byWorld(worldId: WorldId, options: Gw2HttpOptions): Model

    /**
     * Gets the [Model] associated with the world that has id [worldId], or null if unable to fulfill the request.
     */
    suspend fun byWorldOrNull(worldId: WorldId, options: Gw2HttpOptions): Model?
}