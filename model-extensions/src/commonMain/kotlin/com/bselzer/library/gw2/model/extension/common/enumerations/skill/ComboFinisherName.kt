package com.bselzer.library.gw2.model.extension.common.enumerations.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ComboFinisherName
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