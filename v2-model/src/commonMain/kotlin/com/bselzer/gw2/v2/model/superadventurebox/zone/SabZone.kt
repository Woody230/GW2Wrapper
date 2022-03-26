package com.bselzer.gw2.v2.model.superadventurebox.zone

import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SabZone(
    /**
     * The id of the world.
     */
    @SerialName("id")
    override val id: SabZoneId = SabZoneId(),

    /**
     * The difficulty mode cleared.
     */
    @SerialName("mode")
    val difficulty: String = "",

    /**
     * The number of the world.
     */
    @SerialName("world")
    val world: Int = 0,

    /**
     * The number of the zone.
     */
    @SerialName("zone")
    val zone: Int = 0
) : Identifiable<Int>