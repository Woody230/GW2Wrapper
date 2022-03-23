package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MountName {
    @SerialName("griffon")
    GRIFFON,

    @SerialName("jackal")
    JACKAL,

    @SerialName("raptor")
    RAPTOR,

    @SerialName("roller_beetle")
    ROLLER_BEETLE,

    @SerialName("siege_turtle")
    SIEGE_TURTLE,

    @SerialName("skiff")
    SKIFF,

    @SerialName("skimmer")
    SKIMMER,

    @SerialName("skyscale")
    SKYSCALE,

    @SerialName("springer")
    SPRINGER,

    @SerialName("warclaw")
    WARCLAW
}