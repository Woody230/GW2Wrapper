package com.bselzer.library.gw2.v2.model.common.mount

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MountSkill(
    @SerialName("id")
    val id: Int = 0,

    @SerialName("slot")
    val slot: String = ""
)