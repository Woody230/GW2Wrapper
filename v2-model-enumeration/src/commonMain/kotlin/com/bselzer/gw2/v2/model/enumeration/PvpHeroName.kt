package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PvpHeroName {
    @SerialName("Nika")
    NIKA,

    @SerialName("Lightbringer Tybalt Leftpaw")
    TYBALT,

    @SerialName("Turai Ossa")
    TURAI,

    @SerialName("Grymm Svaard")
    GRYMM
}