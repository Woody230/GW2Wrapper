package com.bselzer.library.gw2.v2.model.common.character

import kotlinx.serialization.Serializable

@Serializable
data class WvwAbility(
    /**
     * The id of the ability.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    val id: Int = 0,

    /**
     * The rank of the ability.
     */
    val rank: Int = 0
)