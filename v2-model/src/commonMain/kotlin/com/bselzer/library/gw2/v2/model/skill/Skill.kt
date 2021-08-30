package com.bselzer.library.gw2.v2.model.skill

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.gw2.v2.model.skill.fact.SkillFact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Skill(
    @SerialName("id")
    override val id: Int,

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("chat_link")
    val chatLink: String = "",

    @SerialName("type")
    val type: String = "",

    /**
     * The required weapon type.
     */
    @SerialName("weapon_type")
    val weaponType: String = "None",

    /**
     * The professions that can use this skill.
     */
    @SerialName("professions")
    val professions: List<String> = emptyList(),

    /**
     * The slot and/or slot number this skill belongs to.
     */
    @SerialName("slot")
    val slot: String = "",

    /**
     * The information about this skill's effects.
     */
    @SerialName("facts")
    val facts: List<SkillFact> = emptyList(),

    /**
     * The information about this skill's effects dependent on selected traits.
     */
    @SerialName("traited_facts")
    val traitedFacts: List<SkillFact> = emptyList(),

    @SerialName("categories")
    val categories: List<String> = emptyList(),

    /**
     * The required attunement. For Elementalists only.
     */
    @SerialName("attunement")
    val attunement: String = "",

    /**
     * The required secondary attunement. For Weavers only.
     */
    @SerialName("dual_attunement")
    val dualAttunement: String = "",

    /**
     * The energy cost. For Revenants, Warriors, and Druids only.
     */
    @SerialName("cost")
    val cost: Int = 0,

    /**
     * The weapon type of the required offhand. For Thieves only.
     */
    @SerialName("dual_wield")
    val dualWield: String = "",

    /**
     * The id of the skill that "flips over" when this skill is used. Examples include Engineer toolkits and Herald facets.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("flip_skill")
    val flipId: Int = 0,

    /**
     * The amount of initiative required and used to perform the skill. For Thieves only.
     */
    @SerialName("initiative")
    val initiativeCost: Int = 0,

    /**
     * The id of the next skill in a chain of skills.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("next_chain")
    val nextChainId: Int = 0,

    /**
     * The id of the previous skill in a chain of skills.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("prev_chain")
    val previousChainId: Int = 0,

    /**
     * The id of the elite specialization required.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    @SerialName("specialization")
    val specializationId: Int = 0,

    /**
     * The ids of the transformation skills that replace the skill bar upon use of this skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("transform_skills")
    val transformIds: List<Int> = emptyList(),

    /**
     * The ids of the bundle skills that replace the skill bar upon use of this skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("bundle_skills")
    val bundleIds: List<Int> = emptyList(),

    /**
     * The id of the associated toolbelt skill id. For Engineers only.
     */
    @SerialName("toolbelt_skill")
    val toolbeltId: Int = 0,

    @SerialName("flags")
    val flags: List<String> = emptyList()
) : Identifiable<Int>