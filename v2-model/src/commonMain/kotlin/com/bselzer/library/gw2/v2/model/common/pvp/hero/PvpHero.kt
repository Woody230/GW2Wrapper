package com.bselzer.library.gw2.v2.model.common.pvp.hero

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpHero(
    /**
     * The id of the hero in the form of a UUID.
     */
    @SerialName("id")
    val id: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("type")
    val type: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("stats")
    val stats: PvpHeroStats = PvpHeroStats(),

    @SerialName("overlay")
    val overlayLink: String = "",

    @SerialName("underlay")
    val underlayLink: String = "",

    @SerialName("skins")
    val skins: List<PvpHeroSkin> = emptyList()
)