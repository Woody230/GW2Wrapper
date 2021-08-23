package com.bselzer.library.gw2.v2.model.enumeration.wvw

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ObjectiveType
{
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