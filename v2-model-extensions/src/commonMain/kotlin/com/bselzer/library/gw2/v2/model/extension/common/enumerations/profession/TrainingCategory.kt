package com.bselzer.library.gw2.v2.model.extension.common.enumerations.profession

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