package com.bselzer.gw2.v2.model.extension.world

import com.bselzer.gw2.v2.model.world.World

/**
 * The id of the world wrapped by a [WorldId].
 */
fun World.worldId(): WorldId = WorldId(id)