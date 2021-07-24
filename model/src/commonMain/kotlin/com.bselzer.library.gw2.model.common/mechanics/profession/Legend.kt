package com.bselzer.library.gw2.model.common.mechanics.profession

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Legend(
    @SerialName("id")
    val id: String,

    @SerialName("code")
    val buildTemplateId: Int,

    @SerialName("swap")
    val swapLegendSkillId: Int = 0,

    @SerialName("heal")
    val healSkillId: Int = 0,

    @SerialName("elite")
    val eliteSkillId: Int = 0,

    @SerialName("utilities")
    val utilitySkillIds: List<Int> = emptyList()
)