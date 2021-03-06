package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GuildEmblemFlag {
    @SerialName("FlipBackgroundHorizontal")
    FLIP_BACKGROUND_HORIZONTAL,

    @SerialName("FlipBackgroundVertical")
    FLIP_BACKGROUND_VERTICAL
}