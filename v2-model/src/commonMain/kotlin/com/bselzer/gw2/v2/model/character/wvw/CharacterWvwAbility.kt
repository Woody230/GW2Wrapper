package com.bselzer.gw2.v2.model.character.wvw

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.wvw.ability.WvwAbilityId
import com.bselzer.gw2.v2.model.wvw.rank.WvwLevel
import kotlinx.serialization.Serializable

@Serializable
data class CharacterWvwAbility(
    /**
     * The id of the ability.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    override val id: WvwAbilityId = WvwAbilityId(),

    /**
     * The rank of the ability.
     */
    val rank: WvwLevel = WvwLevel()
) : Identifiable<Int>