package com.bselzer.library.gw2.v2.model.common.profession.skill

import kotlinx.serialization.SerialName

class ElementalistSkill(
    override val id: Int = 0,
    override val slot: String = "",

    /**
     * The name of the required attunement.
     */
    @SerialName("attunement")
    val attunementRequired: String = ""
) : ProfessionSkill()