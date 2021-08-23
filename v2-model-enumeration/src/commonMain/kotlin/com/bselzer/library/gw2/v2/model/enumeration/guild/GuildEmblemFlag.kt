package com.bselzer.library.gw2.v2.model.enumeration.guild

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GuildEmblemFlag
{
    @SerialName("FlipBackgroundHorizontal")
    FLIP_BACKGROUND_HORIZONTAL,

    @SerialName("FlipBackgroundVertical")
    FLIP_BACKGROUND_VERTICAL
}