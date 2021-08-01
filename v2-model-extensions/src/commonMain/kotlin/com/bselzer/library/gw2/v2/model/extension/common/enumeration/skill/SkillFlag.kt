package com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SkillFlag
{
    @SerialName("GroundTargeted")
    GROUND_TARGETED,

    @SerialName("NoUnderwater")
    NO_UNDERWATER;
}