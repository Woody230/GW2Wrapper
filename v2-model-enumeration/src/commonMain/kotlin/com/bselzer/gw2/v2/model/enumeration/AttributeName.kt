package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AttributeName {
    @SerialName("AgonyResistance")
    AGONY_RESISTANCE,

    @SerialName("BoonDuration")
    CONCENTRATION,

    @SerialName("ConditionDamage")
    CONDITION_DAMAGE,

    @SerialName("ConditionDuration")
    EXPERTISE,

    @SerialName("CritDamage")
    FEROCITY,

    @SerialName("Healing")
    HEALING_POWER,

    @SerialName("Power")
    POWER,

    @SerialName("Precision")
    PRECISION,

    @SerialName("Toughness")
    TOUGHNESS,

    @SerialName("Vitality")
    VITALITY
}