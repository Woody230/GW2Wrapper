package com.bselzer.gw2.v2.model.account.mastery

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import com.bselzer.gw2.v2.model.mastery.Mastery
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountMastery(
    /**
     * The id of the mastery.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/masteries">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The index into the [Mastery.levels] collection.
     */
    @SerialName("level")
    val level: Int = 0
) : Identifiable<Int>