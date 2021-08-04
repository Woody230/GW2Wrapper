package com.bselzer.library.gw2.v2.model.common.account.mastery

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountMastery(
    /**
     * The id of the mastery.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    @SerialName("id")
    val id: Int = 0,

    /**
     * The index into the /v2/masteries.levels collection.
     */
    // TODO update docs: replace endpoint reference with object reference
    @SerialName("level")
    val level: Int = 0
)