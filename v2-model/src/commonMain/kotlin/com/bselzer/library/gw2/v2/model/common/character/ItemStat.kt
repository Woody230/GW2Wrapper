package com.bselzer.library.gw2.v2.model.common.character

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemStat(
    /**
     * The id of the item stat.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    @SerialName("id")
    val id: Int = 0,

    /**
     * The name of the stats mapped to the amounts.
     * @see <a href="https://wiki.guildwars2.com/wiki/Attribute">the wiki</a>
     */
    @SerialName("attributes")
    val attributes: Map<String, Double> = emptyMap()
)