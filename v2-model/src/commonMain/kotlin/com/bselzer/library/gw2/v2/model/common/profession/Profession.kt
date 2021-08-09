package com.bselzer.library.gw2.v2.model.common.profession

import com.bselzer.library.gw2.v2.model.common.profession.skill.ProfessionSkill
import com.bselzer.library.kotlin.extension.serialization.common.serializer.MapArraySerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profession(
    @SerialName("id")
    val id: String,

    @SerialName("name")
    val name: String = "",

    /**
     * The id used in build template chat links.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Build_template_link">the wiki</a>
     */
    @SerialName("code")
    val buildTemplateId: Int,

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("icon_big")
    val iconLinkBig: String = "",

    /**
     * The ids of the specializations that can be chosen.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    @SerialName("specializations")
    val specializationIds: List<Int> = emptyList(),

    @SerialName("training")
    val training: List<Training> = emptyList(),

    /**
     * The names of the weapon types mapped to its details.
     */
    @SerialName("weapons")
    val weapons: Map<String, ProfessionWeapon> = emptyMap(),

    @SerialName("flags")
    val flags: List<String> = emptyList(),

    @SerialName("skills")
    val skills: List<ProfessionSkill> = emptyList(),

    /**
     * A mapping of the skill ids to palette ids used in creating a build template chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Build_template_link">the wiki</a>
     */
    @Serializable(with = MapArraySerializer::class)
    @SerialName("skills_by_palette")
    val buildTemplateIds: Map<Int, Int> = emptyMap()
)
