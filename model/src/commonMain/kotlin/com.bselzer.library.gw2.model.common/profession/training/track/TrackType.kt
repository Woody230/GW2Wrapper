package com.bselzer.library.gw2.model.common.profession.training.track

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TrackType
{
    @SerialName("Trait")
    TRAIT,

    @SerialName("Skill")
    SKILL;
}