package com.bselzer.gw2.v2.model.item.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MiniDetails(
    /**
     * The id of the mini.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/minis">the wiki</a>
     */
    @SerialName("minipet_id")
    val miniId: Int = 0
)