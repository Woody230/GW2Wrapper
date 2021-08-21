package com.bselzer.library.gw2.v2.model.enumeration.common.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ComboFinisherType
{
    @SerialName("Blast")
    BLAST,

    @SerialName("Leap")
    LEAP,

    @SerialName("Projectile")
    PROJECTILE,

    @SerialName("Whirl")
    WHIRL;
}