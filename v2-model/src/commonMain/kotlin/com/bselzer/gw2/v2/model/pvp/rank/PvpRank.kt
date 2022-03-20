package com.bselzer.gw2.v2.model.pvp.rank

import com.bselzer.gw2.v2.model.finisher.FinisherId
import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpRank(
    /**
     * The id of the rank.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    @SerialName("id")
    override val id: PvpRankId = PvpRankId(),

    /**
     * The id of the finisher.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/finishers">the wiki</a>
     */
    @SerialName("finisher_id")
    val finisherId: FinisherId = FinisherId(),

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
) : Identifiable<Int>