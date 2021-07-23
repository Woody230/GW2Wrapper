package com.bselzer.library.gw2.model.common.profession.training

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TrainingCategory
{
    @SerialName("Skills")
    SKILLS,

    @SerialName("Specializations")
    SPECIALIZATIONS,

    @SerialName("EliteSpecializations")
    ELITE_SPECIALIZATIONS;
}