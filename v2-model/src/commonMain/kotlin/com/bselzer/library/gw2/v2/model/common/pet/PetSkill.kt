package com.bselzer.library.gw2.v2.model.common.pet

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PetSkill(
    /**
     * The id of the skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("id")
    val id: Int = 0
)
