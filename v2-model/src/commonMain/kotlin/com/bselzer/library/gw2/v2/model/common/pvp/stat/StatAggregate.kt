package com.bselzer.library.gw2.v2.model.common.pvp.stat

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatAggregate(
    /**
     * The number of wins.
     */
    @SerialName("wins")
    val wins: Int = 0,

    /**
     * The number of losses.
     */
    @SerialName("losses")
    val losses: Int = 0,

    /**
     * The number of desertions.
     */
    @SerialName("desertions")
    val desertions: Int = 0,

    /**
     * The number of byes.
     */
    @SerialName("byes")
    val byes: Int = 0,

    /**
     * The number of forfeits.
     */
    @SerialName("forfeits")
    val forfeits: Int = 0
)