package com.bselzer.library.gw2.model.common.mechanics.profession.training.track

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Track(
    @SerialName("cost")
    val cost: Int = 0,

    @SerialName("type")
    val type: TrackType? = null,

    @SerialName("skill_id")
    val skillId: Int = 0,

    @SerialName("trait_id")
    val traitId: Int = 0
)
