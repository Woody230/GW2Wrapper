package com.bselzer.gw2.v2.model.enumeration.trait

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TraitTier {
    @SerialName("0")
    PROFICIENCY,

    @SerialName("1")
    ADEPT,

    @SerialName("2")
    MASTER,

    @SerialName("3")
    GRANDMASTER,
}