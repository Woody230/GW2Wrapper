package com.bselzer.gw2.v2.model.pvp.season.rank

import com.bselzer.gw2.v2.model.wrapper.ImageLink
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
    val iconLink: ImageLink = ImageLink(),

    @SerialName("overlay")
    val overlayLinkBig: ImageLink = ImageLink(),

    @SerialName("overlay_small")
    val overlayLink: ImageLink = ImageLink(),

    @SerialName("tiers")
    val tiers: List<PvpSeasonRankTier> = emptyList()
)