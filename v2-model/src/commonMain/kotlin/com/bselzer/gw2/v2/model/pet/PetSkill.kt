package com.bselzer.gw2.v2.model.pet

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PetSkill(
    /**
     * The id of the skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0
) : Identifiable<Int>
