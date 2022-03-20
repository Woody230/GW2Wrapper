package com.bselzer.gw2.v2.model.wvw.world

import com.bselzer.gw2.v2.model.world.WorldId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwWorldId(
    @SerialName("red")
    val red: WorldId = WorldId(),

    @SerialName("blue")
    val blue: WorldId = WorldId(),

    @SerialName("green")
    val green: WorldId = WorldId()
)