package com.bselzer.gw2.v2.model.pvp.season.division

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpDivision(
    @SerialName("name")
    val name: String = "",

    @SerialName("flags")
    val flags: List<String> = emptyList(),

    @SerialName("large_icon")
    val iconLinkBig: String = "",

    @SerialName("small_icon")
    val iconLink: String = "",

    @SerialName("pip_icon")
    val pipIconLink: String = "",

    @SerialName("tiers")
    val tiers: List<PvpDivisionTier> = emptyList()
)