package com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class EffectName
{
    @SerialName("Aegis")
    AEGIS,

    @SerialName("Fury")
    FURY,

    @SerialName("Might")
    MIGHT,

    @SerialName("Protection")
    PROTECTION,

    @SerialName("Quickness")
    QUICKNESS,

    @SerialName("Regeneration")
    REGENERATION,

    @SerialName("Resistance")
    RESISTANCE,

    @SerialName("Resolution")
    RESOLUTION,

    @SerialName("Retaliation")
    RETALIATION,

    @SerialName("Stability")
    STABILITY,

    @SerialName("Swiftness")
    SWIFTNESS,

    @SerialName("Vigor")
    VIGOR,

    @SerialName("Bleeding")
    BLEEDING,

    @SerialName("Blinded")
    BLINDED,

    @SerialName("Burning")
    BURNING,

    @SerialName("Chilled")
    CHILLED,

    @SerialName("Confusion")
    CONFUSION,

    @SerialName("Crippled")
    CRIPPLED,

    @SerialName("Fear")
    FEAR,

    @SerialName("Immobile")
    IMMOBILE,

    @SerialName("Poison")
    POISON,

    @SerialName("Slow")
    SLOW,

    @SerialName("Taunt")
    TAUNT,

    @SerialName("Torment")
    TORMENT,

    @SerialName("Vulnerability")
    VULNERABILITY,

    @SerialName("Weakness")
    WEAKNESS,

    @SerialName("Daze")
    DAZE,

    @SerialName("Float")
    FLOAT,

    @SerialName("Knockback")
    KNOCKACK,

    @SerialName("Launch")
    LAUNCH,

    @SerialName("Pull")
    PULL,

    @SerialName("Sink")
    SINK,

    @SerialName("Stun")
    STUN,

    @SerialName("Agony")
    AGONY_RESISTANCE,

    @SerialName("Alacrity")
    ALACRITY,

    @SerialName("Invulnerability")
    INVULNERABILITY,

    @SerialName("Revealed")
    REVEALED,

    @SerialName("Stealth")
    STEALTH,

    @SerialName("Superspeed")
    SUPERSPEED;
}