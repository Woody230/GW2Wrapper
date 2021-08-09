package com.bselzer.library.gw2.v2.model.common.profession.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class ProfessionSkill
{
    /**
     * The id of the skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("id")
    abstract val id: Int

    /**
     * The skill slot the skill belongs to.
     */
    @SerialName("slot")
    abstract val slot: String
}