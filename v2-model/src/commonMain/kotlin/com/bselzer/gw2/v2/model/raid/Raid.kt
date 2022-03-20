package com.bselzer.gw2.v2.model.raid

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.raid.wing.RaidWing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Raid(
    /**
     * The name of the raid.
     */
    @SerialName("id")
    override val id: RaidId = RaidId(),

    @SerialName("wings")
    val wings: List<RaidWing> = emptyList()
) : Identifiable<String>