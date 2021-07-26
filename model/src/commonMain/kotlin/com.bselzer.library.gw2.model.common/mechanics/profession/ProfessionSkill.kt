package com.bselzer.library.gw2.model.common.mechanics.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionSkill(
    @SerialName("id")
    val id: Int = 0,

    @SerialName("slot")
    val slot: String = "",

    @SerialName("type")
    val type: String = "",

    @SerialName("offhand")
    val offhandRequired: String = "", // For Thief

    @SerialName("attunement")
    val attunementRequired: String = "", // For Elementalist

    @SerialName("source")
    val stealSource: String = "" // For Thief
)