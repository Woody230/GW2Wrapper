package com.bselzer.gw2.v2.model.raid

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RaidEvent(
    /**
     * The name of the event/encounter.
     */
    // TODO enum and extension
    @SerialName("id")
    override val id: String = "",

    @SerialName("type")
    val type: String = ""
) : Identifiable<String>