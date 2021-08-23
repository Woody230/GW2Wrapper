package com.bselzer.library.gw2.v2.model.character.superadventurebox

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SabZone(
    /**
     * The id of the world.
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The difficulty mode cleared.
     */
    @SerialName("mode")
    val difficulty: String = "",

    /**
     * The number of the world.
     */
    @SerialName("world")
    val worldNumber: Int = 0,

    /**
     * The number of the zone.
     */
    @SerialName("zone")
    val zoneNumber: Int = 0
) : Identifiable<Int>