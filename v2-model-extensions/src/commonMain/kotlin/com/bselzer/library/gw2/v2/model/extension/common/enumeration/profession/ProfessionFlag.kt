package com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ProfessionFlag
{
    @SerialName("NoRacialSkills")
    NO_RACIAL_SKILLS,

    @SerialName("NoWeaponSwap")
    NO_WEAPON_SWAP;
}