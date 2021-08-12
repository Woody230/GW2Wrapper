package com.bselzer.library.gw2.v2.model.common.profession.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ElementalistSkill(
    /**
     * The name of the required attunement.
     */
    @SerialName("attunement")
    val attunementRequired: String = ""
) : ProfessionSkill()