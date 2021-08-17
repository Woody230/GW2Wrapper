package com.bselzer.library.gw2.v2.model.common.character.superadventurebox

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SabUnlock(
    /**
     * The id of the unlocked object.
     */
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The name of the upgrade.
     */
    @SerialName("name")
    val name: String = ""
) : Identifiable<Int>