package com.bselzer.gw2.v2.model.profession

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfessionSkill(
    /**
     * The id of the skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The skill slot the skill belongs to.
     */
    @SerialName("slot")
    val slot: String = "",

    /**
     * The name of the required attunement. Used by Elementalists.
     */
    @SerialName("attunement")
    val attunement: String = "",

    /**
     * The name of the profession that the skill is stolen from. Used by Thieves for their Steal skill.
     */
    @SerialName("source")
    val source: String = ""
) : Identifiable<Int>