package com.bselzer.library.gw2.model.common.pet

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PetSkill(
    @SerialName("id")
    val id: Int = 0
)
