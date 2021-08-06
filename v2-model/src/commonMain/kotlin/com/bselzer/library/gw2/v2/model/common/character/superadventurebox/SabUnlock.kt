package com.bselzer.library.gw2.v2.model.common.character.superadventurebox

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SabUnlock(
    /**
     * The id of the unlocked object.
     */
    @SerialName("id")
    val id: Int = 0,

    /**
     * The name of the upgrade.
     */
    @SerialName("name")
    val name: String = ""
)