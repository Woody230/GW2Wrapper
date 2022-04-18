package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CategoryAchievementFlag {
    /**
     * An achievement for the Player vs. Environment mode.
     */
    @SerialName("PvE")
    PVE,

    /**
     * An achievement for the Player vs. Player mode.
     */
    @SerialName("PvP")
    PVP,

    /**
     * An achievement for the World vs. World mode.
     */
    @SerialName("WvW")
    WVW,

    /**
     * An achievement for a special event such as a festival.
     */
    @SerialName("SpecialEvent")
    SPECIAL_EVENT
}