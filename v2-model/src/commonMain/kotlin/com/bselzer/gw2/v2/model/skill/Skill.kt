package com.bselzer.gw2.v2.model.skill

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.profession.ProfessionId
import com.bselzer.gw2.v2.model.skill.fact.SkillFact
import com.bselzer.gw2.v2.model.specialization.SpecializationId
import com.bselzer.gw2.v2.model.wrapper.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Skill(
    @SerialName("id")
    override val id: SkillId = SkillId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("chat_link")
    val chatLink: String = "",

    @SerialName("type")
    val type: SkillType = SkillType(),

    /**
     * The required weapon type.
     */
    @SerialName("weapon_type")
    val weaponType: WeaponType = WeaponType(),

    /**
     * The professions that can use this skill.
     */
    @SerialName("professions")
    val professions: List<ProfessionId> = emptyList(),

    /**
     * The slot and/or slot number this skill belongs to.
     */
    @SerialName("slot")
    val slot: SkillSlot = SkillSlot(),

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
    val categories: List<SkillCategory> = emptyList(),

    /**
     * The required attunement. For Elementalists only.
     */
    @SerialName("attunement")
    val attunement: AttunementName = AttunementName(),

    /**
     * The required secondary attunement. For Weavers only.
     */
    @SerialName("dual_attunement")
    val dualAttunement: AttunementName = AttunementName(),

    /**
     * The energy cost. For Revenants, Warriors, and Druids only.
     */
    @SerialName("cost")
    val cost: Int = 0,

    /**
     * The weapon type of the required offhand. For Thieves only.
     */
    @SerialName("dual_wield")
    val dualWield: WeaponType = WeaponType(),

    /**
     * The id of the skill that "flips over" when this skill is used. Examples include Engineer toolkits and Herald facets.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("flip_skill")
    val flipId: SkillId = SkillId(),

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
    val nextChainId: SkillId = SkillId(),

    /**
     * The id of the previous skill in a chain of skills.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("prev_chain")
    val previousChainId: SkillId = SkillId(),

    /**
     * The id of the elite specialization required.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    @SerialName("specialization")
    val specializationId: SpecializationId = SpecializationId(),

    /**
     * The ids of the transformation skills that replace the skill bar upon use of this skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("transform_skills")
    val transformIds: List<SkillId> = emptyList(),

    /**
     * The ids of the bundle skills that replace the skill bar upon use of this skill.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/skills">the wiki</a>
     */
    @SerialName("bundle_skills")
    val bundleIds: List<SkillId> = emptyList(),

    /**
     * The id of the associated toolbelt skill id. For Engineers only.
     */
    @SerialName("toolbelt_skill")
    val toolbeltId: SkillId = SkillId(),

    @SerialName("flags")
    val flags: List<SkillFlag> = emptyList()
) : Identifiable<Int>