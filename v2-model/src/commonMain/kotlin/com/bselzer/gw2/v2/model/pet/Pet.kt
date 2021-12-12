package com.bselzer.gw2.v2.model.pet

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pet(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("skills")
    val skills: List<PetSkill> = emptyList()
) : Identifiable<Int>