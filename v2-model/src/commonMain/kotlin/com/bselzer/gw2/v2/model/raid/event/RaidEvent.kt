package com.bselzer.gw2.v2.model.raid.event

import com.bselzer.gw2.v2.model.enumeration.wrapper.RaidEventType
import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RaidEvent(
    /**
     * The name of the event/encounter.
     */
    @SerialName("id")
    override val id: RaidEventId = RaidEventId(),

    @SerialName("type")
    val type: RaidEventType = RaidEventType()
) : Identifiable<String>