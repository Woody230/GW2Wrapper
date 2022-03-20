package com.bselzer.gw2.v2.model.wvw.world

import com.bselzer.gw2.v2.model.world.WorldId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwWorldIds(
    @SerialName("red")
    val red: List<WorldId> = emptyList(),

    @SerialName("blue")
    val blue: List<WorldId> = emptyList(),

    @SerialName("green")
    val green: List<WorldId> = emptyList()
)