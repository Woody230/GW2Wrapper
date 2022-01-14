package com.bselzer.gw2.v2.model.character

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.Serializable

@Serializable
data class CharacterWvwAbility(
    /**
     * The id of the ability.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    override val id: Int = 0,

    /**
     * The rank of the ability.
     */
    val rank: Int = 0
) : Identifiable<Int>