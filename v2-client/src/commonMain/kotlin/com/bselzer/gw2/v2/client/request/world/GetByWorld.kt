package com.bselzer.gw2.v2.client.request.world

import com.bselzer.gw2.v2.client.exception.Gw2ClientException
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.gw2.v2.model.world.WorldId

interface GetByWorld<Model> {
    /**
     * Gets the [Model] associated with the world that has id [worldId], or a [GetResult.Failure] if unable to fulfill the request.
     */
    suspend fun byWorld(worldId: WorldId, options: Gw2Options = Gw2Options.Default): GetResult<Model>

    /**
     * Gets the [Model] associated with the world that has id [worldId], or throws a [Gw2ClientException] if unable to fulfill the request.
     */
    suspend fun byWorldOrThrow(worldId: WorldId, options: Gw2Options = Gw2Options.Default): Model

    /**
     * Gets the [Model] associated with the world that has id [worldId], or null if unable to fulfill the request.
     */
    suspend fun byWorldOrNull(worldId: WorldId, options: Gw2Options = Gw2Options.Default): Model?
}