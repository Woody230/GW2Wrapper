package com.bselzer.gw2.v2.model.enumeration.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TrainingTrackType {
    @SerialName("Trait")
    TRAIT,

    @SerialName("Skill")
    SKILL;
}