package com.bselzer.gw2.v2.model.raid.wing

import com.bselzer.gw2.v2.model.raid.event.RaidEvent
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RaidWing(
    /**
     * The name of the raid wing.
     */
    @SerialName("id")
    override val id: RaidWingId = RaidWingId(),

    @SerialName("events")
    val events: List<RaidEvent> = emptyList()
) : Identifiable<String>