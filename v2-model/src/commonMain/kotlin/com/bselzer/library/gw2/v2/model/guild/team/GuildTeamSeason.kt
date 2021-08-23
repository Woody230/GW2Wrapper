package com.bselzer.library.gw2.v2.model.guild.team

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildTeamSeason(
    /**
     * The id in the form of a UUID.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    @SerialName("id")
    override val id: String = "",

    @SerialName("wins")
    val wins: Int = 0,

    @SerialName("losses")
    val losses: Int = 0,

    @SerialName("rating")
    val rating: Int = 0
) : Identifiable<String>