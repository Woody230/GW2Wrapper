package com.bselzer.gw2.v2.model.enumeration.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SkillType {
    @SerialName("Bundle")
    BUNDLE, // Engineer kits or weapons picked up in the world.

    @SerialName("Elite")
    ELITE,

    @SerialName("Heal")
    HEAL,

    @SerialName("Profession")
    PROFESSION,

    @SerialName("Utility")
    UTILITY,

    @SerialName("Weapon")
    WEAPON, // Weapon or downed.

    @SerialName("Toolbelt")
    TOOLBELT,

    @SerialName("Monster")
    MONSTER,

    @SerialName("Pet")
    PET,

    @SerialName("Transform")
    TRANSFORM;
}