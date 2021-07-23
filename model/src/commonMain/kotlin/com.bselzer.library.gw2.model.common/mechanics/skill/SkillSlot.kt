package com.bselzer.library.gw2.model.common.mechanics.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SkillSlot
{
    @SerialName("Profession_1")
    PROFESSION_1,

    @SerialName("Profession_2")
    PROFESSION_2,

    @SerialName("Profession_3")
    PROFESSION_3,

    @SerialName("Profession_4")
    PROFESSION_4,

    @SerialName("Profession_5")
    PROFESSION_5,

    @SerialName("Utility")
    UTILITY,

    @SerialName("Heal")
    HEAL,

    @SerialName("Elite")
    ELITE,

    @SerialName("Weapon_1")
    WEAPON_1,

    @SerialName("Weapon_2")
    WEAPON_2,

    @SerialName("Weapon_3")
    WEAPON_3,

    @SerialName("Weapon_4")
    WEAPON_4,

    @SerialName("Weapon_5")
    WEAPON_5,

    @SerialName("Pet")
    PET,

    @SerialName("Downed_1")
    DOWNED_1,

    @SerialName("Downed_2")
    DOWNED_2,

    @SerialName("Downed_3")
    DOWNED_3,

    @SerialName("Downed_4")
    DOWNED_4,

    @SerialName("Toolbelt")
    TOOLBELT,

    @SerialName("Transform_1")
    TRANSFORM_1,

    @SerialName("Transform_2")
    TRANSFORM_2,

    @SerialName("Transform_3")
    TRANSFORM_3,

    @SerialName("Transform_4")
    TRANSFORM_4,

    @SerialName("Transform_5")
    TRANSFORM_5;
}