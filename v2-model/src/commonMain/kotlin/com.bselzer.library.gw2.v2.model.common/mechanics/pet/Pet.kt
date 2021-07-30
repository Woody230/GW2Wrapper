package com.bselzer.library.gw2.v2.model.common.mechanics.pet

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pet(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("skills")
    val skills: List<PetSkill> = emptyList()
)