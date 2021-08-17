package com.bselzer.library.gw2.v2.model.common.legend

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Legend(
    @SerialName("id")
    override val id: String,

    /**
     * The id used in build template chat links.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Build_template_link">the wiki</a>
     */
    @SerialName("code")
    val buildTemplateId: Int,

    /**
     * The id of the profession skill used to swap to this legend.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("swap")
    val swapLegendSkillId: Int = 0,

    /**
     *  The id of the heal skill.
     *  @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("heal")
    val healId: Int = 0,

    /**
     * The id of the elite skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("elite")
    val eliteId: Int = 0,

    /**
     * The ids of the utility skills.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("utilities")
    val utilityIds: List<Int> = emptyList()
) : Identifiable<String>