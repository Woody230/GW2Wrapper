package com.bselzer.library.gw2.v2.model.common.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrainingTrack(
    @SerialName("cost")
    val cost: Int = 0,

    @SerialName("type")
    val type: String = "",

    @SerialName("skill_id")
    val skillId: Int = 0,

    @SerialName("trait_id")
    val traitId: Int = 0
)
