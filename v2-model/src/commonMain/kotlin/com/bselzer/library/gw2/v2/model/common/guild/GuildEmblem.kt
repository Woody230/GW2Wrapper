package com.bselzer.library.gw2.v2.model.common.guild

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildEmblem(
    @SerialName("id")
    val id: Int = 0,

    /**
     * The URLs representing the components of the emblem.
     */
    @SerialName("layers")
    val layers: List<String> = emptyList()
)