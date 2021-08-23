package com.bselzer.library.gw2.v2.model.enumeration.novelty

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class NoveltySlot
{
    @SerialName("Chair")
    CHAIR,

    @SerialName("Music")
    MUSIC,

    @SerialName("HeldItem")
    HELD_ITEM,

    @SerialName("Miscellaneous")
    MISCELLANEOUS,

    @SerialName("Tonic")
    TONIC
}