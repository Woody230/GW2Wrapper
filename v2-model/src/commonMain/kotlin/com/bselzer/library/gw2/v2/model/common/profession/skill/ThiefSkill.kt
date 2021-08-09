package com.bselzer.library.gw2.v2.model.common.profession.skill

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ThiefSkill(
    override val id: Int = 0,
    override val slot: String = "",

    /**
     * The name of the required offhand weapon.
     */
    @SerialName("offhand")
    val offhandRequired: String = "",

    /**
     * The name of the profession that the skill is stolen from.
     */
    @SerialName("source")
    val stealSource: String = ""
) : ProfessionSkill()