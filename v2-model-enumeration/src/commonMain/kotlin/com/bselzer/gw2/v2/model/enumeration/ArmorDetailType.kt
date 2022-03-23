package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ArmorDetailType {
    @SerialName("Boots")
    BOOTS,

    @SerialName("Coat")
    CHEST,

    @SerialName("Gloves")
    GLOVES,

    @SerialName("Helm")
    HELM,

    @SerialName("HelmAquatic")
    BREATHER,

    @SerialName("Leggings")
    LEGGINGS,

    @SerialName("Shoulders")
    SHOULDERS
}