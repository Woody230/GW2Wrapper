package com.bselzer.gw2.v2.model.pvp.hero

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.pvp.hero.skin.PvpHeroSkin
import com.bselzer.gw2.v2.model.pvp.hero.stat.PvpHeroStats
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpHero(
    /**
     * The id of the hero in the form of a UUID.
     */
    @SerialName("id")
    override val id: PvpHeroId = PvpHeroId(),

    @SerialName("name")
    val name: com.bselzer.gw2.v2.model.wrapper.PvpHeroName = com.bselzer.gw2.v2.model.wrapper.PvpHeroName(),

    @SerialName("type")
    val type: com.bselzer.gw2.v2.model.wrapper.PvpHeroType = com.bselzer.gw2.v2.model.wrapper.PvpHeroType(),

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
) : Identifiable<String>