package com.bselzer.library.gw2.v2.model.common.pvp.season

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpSeasonRank(
    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    /**
     * The link to the badge icon on the nameplate.
     */
    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("overlay")
    val overlayLinkBig: String = "",

    @SerialName("overlay_small")
    val overlayLink: String = "",

    @SerialName("tiers")
    val tiers: List<PvpSeasonRankTier> = emptyList()
)