package com.bselzer.library.gw2.v2.model.common.mechanics.pet

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PetSkill(
    @SerialName("id")
    val id: Int = 0
)
