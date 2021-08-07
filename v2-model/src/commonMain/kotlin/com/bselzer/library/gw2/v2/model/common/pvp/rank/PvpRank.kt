package com.bselzer.library.gw2.v2.model.common.pvp.rank

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpRank(
    /**
     * The id of the rank.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    @SerialName("id")
    val id: Int = 0,

    /**
     * The id of the finisher.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    @SerialName("finisher_id")
    val finisherId: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    /**
     * The minimum PvP level to be at this rank.
     */
    @SerialName("min_rank")
    val minRank: Int = 0,

    /**
     * The maximum PvP level to be at this rank.
     */
    @SerialName("max_rank")
    val maxRank: Int = 0,

    @SerialName("levels")
    val levels: List<PvpLevel> = emptyList()
)