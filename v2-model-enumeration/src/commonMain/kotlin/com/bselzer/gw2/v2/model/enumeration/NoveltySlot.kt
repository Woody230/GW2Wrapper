package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class NoveltySlot {
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