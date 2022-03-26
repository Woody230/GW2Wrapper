package com.bselzer.gw2.v2.model.item.detail.infix

import com.bselzer.gw2.v2.model.itemstat.ItemStatId
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfixUpgrade(
    /**
     * The id of the item stat.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    @SerialName("id")
    override val id: ItemStatId = ItemStatId(),

    @SerialName("attributes")
    val attributes: List<InfixAttribute> = emptyList(),

    @SerialName("buff")
    val buff: InfixBuff = InfixBuff()
) : Identifiable<Int>
