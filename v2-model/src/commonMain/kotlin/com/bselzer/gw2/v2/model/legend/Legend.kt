package com.bselzer.gw2.v2.model.legend

import com.bselzer.gw2.v2.model.skill.SkillId
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Legend(
    @SerialName("id")
    override val id: LegendId = LegendId(),

    /**
     * The id used in build template chat links.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Build_template_link">the wiki</a>
     */
    @SerialName("code")
    val code: LegendCode = LegendCode(),

    /**
     * The id of the profession skill used to swap to this legend.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("swap")
    val swapLegendId: SkillId = SkillId(),

    /**
     *  The id of the heal skill.
     *  @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("heal")
    val healId: SkillId = SkillId(),

    /**
     * The id of the elite skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("elite")
    val eliteId: SkillId = SkillId(),

    /**
     * The ids of the utility skills.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("utilities")
    val utilityIds: List<SkillId> = emptyList()
) : Identifiable<LegendId, String>