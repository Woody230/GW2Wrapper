package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WvwObjectiveType {
    @SerialName("Camp")
    CAMP,

    @SerialName("Castle")
    CASTLE,

    @SerialName("Keep")
    KEEP,

    @SerialName("Mercenary")
    MERCENARY,

    @SerialName("Tower")
    TOWER,

    @SerialName("Ruins")
    RUINS,

    @SerialName("Resource")
    RESOURCE,

    @SerialName("Generic")
    GENERIC,

    @SerialName("Spawn")
    SPAWN
}