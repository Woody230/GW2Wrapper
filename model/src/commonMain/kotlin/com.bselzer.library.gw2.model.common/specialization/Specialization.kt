package com.bselzer.library.gw2.model.common.specialization

import com.bselzer.library.gw2.model.common.profession.ProfessionName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Specialization(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: SpecializationName,

    @SerialName("profession")
    val profession: ProfessionName,

    @SerialName("elite")
    val isEliteSpec: Boolean = false,

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("background")
    val backgroundLink: String = "",

    @SerialName("minor_traits")
    val minorTraitIds: List<Int> = emptyList(),

    @SerialName("major_traits")
    val majorTraitIds: List<Int> = emptyList(),

    @SerialName("weapon_trait")
    val weaponTraitId: Int = 0,

    @SerialName("profession_icon")
    val eliteIconLink: String = "",

    @SerialName("profession_icon_big")
    val eliteIconBigLink: String = ""
)