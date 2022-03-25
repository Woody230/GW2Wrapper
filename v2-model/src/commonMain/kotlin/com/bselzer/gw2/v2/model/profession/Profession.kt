package com.bselzer.gw2.v2.model.profession

import com.bselzer.gw2.v2.model.enumeration.wrapper.ProfessionFlag
import com.bselzer.gw2.v2.model.enumeration.wrapper.WeaponType
import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.skill.SkillCode
import com.bselzer.gw2.v2.model.skill.SkillId
import com.bselzer.gw2.v2.model.specialization.SpecializationId
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.serialization.serializer.MapArraySerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profession(
    @SerialName("id")
    override val id: ProfessionId = ProfessionId(),

    @SerialName("name")
    val name: String = "",

    /**
     * The id used in build template chat links.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Build_template_link">the wiki</a>
     */
    @SerialName("code")
    val code: SkillCode = SkillCode(),

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("icon_big")
    val iconLinkBig: ImageLink = ImageLink(),

    /**
     * The ids of the specializations that can be chosen.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    @SerialName("specializations")
    val specializationIds: List<SpecializationId> = emptyList(),

    @SerialName("training")
    val trainings: List<Training> = emptyList(),

    /**
     * The weapon types mapped to its details.
     */
    @SerialName("weapons")
    val weapons: Map<WeaponType, ProfessionWeapon> = emptyMap(),

    @SerialName("flags")
    val flags: List<ProfessionFlag> = emptyList(),

    @SerialName("skills")
    val skills: List<ProfessionSkill> = emptyList(),

    /**
     * A mapping of the skill ids to palette ids used in creating a build template chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Build_template_link">the wiki</a>
     */
    @Serializable(with = MapArraySerializer::class)
    @SerialName("skills_by_palette")
    val skillPaletteIds: Map<SkillId, SkillCode> = emptyMap()
) : Identifiable<String>
