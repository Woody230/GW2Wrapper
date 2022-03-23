package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ComboFinisherType {
    @SerialName("Blast")
    BLAST,

    @SerialName("Leap")
    LEAP,

    @SerialName("Projectile")
    PROJECTILE,

    @SerialName("Whirl")
    WHIRL;
}