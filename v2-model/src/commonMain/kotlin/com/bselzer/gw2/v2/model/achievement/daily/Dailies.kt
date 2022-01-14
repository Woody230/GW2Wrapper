package com.bselzer.gw2.v2.model.achievement.daily

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The collection of dailies for different content modes.
 */
@Serializable
data class Dailies(
    /**
     * The dailies for the player vs. environment game mode.
     */
    @SerialName("pve")
    val pve: List<Daily> = emptyList(),

    /**
     * The dailies for the player vs. player game mode.
     */
    @SerialName("pvp")
    val pvp: List<Daily> = emptyList(),

    /**
     * The dailies for the world vs. world game mode.
     */
    @SerialName("wvw")
    val wvw: List<Daily> = emptyList(),

    /**
     * The dailies for fractals.
     */
    @SerialName("fractals")
    val fractals: List<Daily> = emptyList(),

    /**
     * The dailies for temporary content such as festivals.
     */
    @SerialName("special")
    val special: List<Daily> = emptyList()
)