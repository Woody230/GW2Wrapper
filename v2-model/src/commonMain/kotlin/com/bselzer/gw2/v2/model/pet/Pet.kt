package com.bselzer.gw2.v2.model.pet

import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pet(
    @SerialName("id")
    override val id: PetId = PetId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("skills")
    val skills: List<PetSkill> = emptyList()
) : Identifiable<Int>