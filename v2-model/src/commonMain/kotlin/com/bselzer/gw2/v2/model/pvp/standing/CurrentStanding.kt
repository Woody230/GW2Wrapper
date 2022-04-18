package com.bselzer.gw2.v2.model.pvp.standing

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("current")
data class CurrentStanding(
    /**
     * The current rating level.
     * @since season 5
     */
    @SerialName("rating")
    val rating: Int = 0,

    /**
     * The number of points decayed.
     * @since season 5
     */
    @SerialName("decay")
    val decay: Int = 0
) : PvpStanding()