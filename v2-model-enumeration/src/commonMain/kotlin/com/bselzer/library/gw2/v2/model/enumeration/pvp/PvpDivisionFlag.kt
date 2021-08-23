package com.bselzer.library.gw2.v2.model.enumeration.pvp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PvpDivisionFlag
{
    /**
     * Whether the player can lose points in this division.
     */
    @SerialName("CanLosePoints")
    CAN_LOSE_POINTS,

    /**
     * Whether the player can lose tiers in this division.
     */
    @SerialName("CanLoseTiers")
    CAN_LOSE_TIERS,

    /**
     * Whether the division is repeatable.
     */
    @SerialName("Repeatable")
    REPEATABLE
}