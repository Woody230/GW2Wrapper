package com.bselzer.gw2.v2.model.raid

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Raid(
    /**
     * The name of the dungeon.
     */
    // TODO enum and extension
    @SerialName("id")
    override val id: String = "",

    @SerialName("wings")
    val wings: List<RaidWing> = emptyList()
) : Identifiable<String>