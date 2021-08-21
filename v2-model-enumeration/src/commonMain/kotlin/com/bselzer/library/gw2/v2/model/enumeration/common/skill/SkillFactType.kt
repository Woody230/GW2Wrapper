package com.bselzer.library.gw2.v2.model.enumeration.common.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SkillFactType
{
    @SerialName("AttributeAdjust")
    ATTRIBUTE_ADJUST,

    @SerialName("Buff")
    BUFF,

    @SerialName("BuffConversion")
    BUFF_CONVERSION,

    @SerialName("ComboField")
    COMBO_FIELD,

    @SerialName("ComboFinisher")
    COMBO_FINISHER,

    @SerialName("Damage")
    DAMAGE,

    @SerialName("Distance")
    DISTANCE,

    @SerialName("Duration")
    DURATION,

    @SerialName("Heal")
    HEAL,

    @SerialName("HealingAdjust")
    HEALING_ADJUST,

    @SerialName("NoData")
    NO_DATA,

    @SerialName("Number")
    NUMBER,

    @SerialName("Percent")
    PERCENT,

    @SerialName("PrefixedBuff")
    PREFIXED_BUFF,

    @SerialName("Radius")
    RADIUS,

    @SerialName("Range")
    RANGE,

    @SerialName("Recharge")
    RECHARGE,

    @SerialName("Time")
    TIME,

    @SerialName("Unblockable")
    UNBLOCKABLE,

    @SerialName("StunBreak")
    STUN_BREAK;
}