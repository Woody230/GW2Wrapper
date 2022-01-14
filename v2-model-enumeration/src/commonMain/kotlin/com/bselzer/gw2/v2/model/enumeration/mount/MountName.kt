package com.bselzer.gw2.v2.model.enumeration.mount

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MountName {
    @SerialName("Griffon")
    GRIFFON,

    @SerialName("Jackal")
    JACKAL,

    @SerialName("Raptor")
    RAPTOR,

    @SerialName("Roller Beetle")
    ROLLER_BEETLE,

    @SerialName("Skimmer")
    SKIMMER,

    @SerialName("Skyscale")
    SKYSCALE,

    @SerialName("Springer")
    SPRINGER,

    @SerialName("Warclaw")
    WARCLAW
}