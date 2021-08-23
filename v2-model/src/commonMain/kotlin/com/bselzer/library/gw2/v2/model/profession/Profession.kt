package com.bselzer.library.gw2.v2.model.profession

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.kotlin.extension.serialization.serializer.MapArraySerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profession(
    @SerialName("id")
    override val id: String,

    @SerialName("name")
    val name: String = "",

    /**
     * The id used in build template chat links.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Build_template_link">the wiki</a>
     */
    @SerialName("code")
    val buildTemplateId: Int = 0,

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
    val trainings: List<Training> = emptyList(),

    /**
     * The weapon types mapped to its details.
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
    val skillPaletteIds: Map<Int, Int> = emptyMap()
) : Identifiable<String>
