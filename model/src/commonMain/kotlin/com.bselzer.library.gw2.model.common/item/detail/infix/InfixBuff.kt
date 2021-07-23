package com.bselzer.library.gw2.model.common.item.detail.infix

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfixBuff(
    @SerialName("skill_id")
    val skillId: Int = 0,

    @SerialName("description")
    val description: String = ""
)
