package com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TrainingTrackType
{
    @SerialName("Trait")
    TRAIT,

    @SerialName("Skill")
    SKILL;
}