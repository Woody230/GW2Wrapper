package com.bselzer.library.gw2.v2.model.common.item.detail.infix

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfixUpgrade(
    /**
     * The id of the item stat.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/itemstats">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("attributes")
    val attributes: List<InfixAttribute> = emptyList(),

    @SerialName("buff")
    val buff: InfixBuff = InfixBuff()
) : Identifiable<Int>
