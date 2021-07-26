package com.bselzer.library.gw2.model.common.mechanics.profession

import com.bselzer.library.kotlin.extension.serialization.common.serializer.MapArraySerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profession(
    @SerialName("id")
    val id: String,

    @SerialName("name")
    val name: String = "",

    @SerialName("code")
    val buildTemplateId: Int,

    @SerialName("icon")
    val iconSmallLink: String = "",

    @SerialName("icon_big")
    val iconBigLink: String = "",

    @SerialName("specializations")
    val specializationIds: List<Int> = emptyList(),

    @SerialName("training")
    val training: List<Training> = emptyList(),

    @SerialName("weapons")
    val weapons: Map<String, ProfessionWeapon> = emptyMap(),

    @SerialName("flags")
    val flags: List<String> = emptyList(),

    @SerialName("skills")
    val skills: List<ProfessionSkill> = emptyList(),

    /**
     * A mapping of the skill ids to palette ids used in creating a build template link.
     * For some reason json arrays are used instead of objects.
     */
    @Serializable(with = MapArraySerializer::class)
    @SerialName("skills_by_palette")
    val buildTemplateIds: Map<Int, Int> = emptyMap()
)
