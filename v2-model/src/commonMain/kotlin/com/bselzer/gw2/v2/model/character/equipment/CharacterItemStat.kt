package com.bselzer.gw2.v2.model.character.equipment

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.itemstat.ItemStatId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterItemStat(
    /**
     * The id of the item stat.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    @SerialName("id")
    override val id: ItemStatId = ItemStatId(),

    /**
     * The name of the stats mapped to the amounts.
     * @see <a href="https://wiki.guildwars2.com/wiki/Attribute">the wiki</a>
     */
    @SerialName("attributes")
    val attributes: Map<com.bselzer.gw2.v2.model.wrapper.AttributeName, Double> = emptyMap()
) : Identifiable<Int>