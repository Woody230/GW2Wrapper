package com.bselzer.library.gw2.v2.model.enumeration.continent

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PointOfInterestType
{
    /**
     * An actual in-game point of interest.
     */
    @SerialName("landmark")
    LANDMARK,

    @SerialName("waypoint")
    WAYPOINT,

    @SerialName("vista")
    VISTA,

    @SerialName("unlock")
    UNLOCK
}