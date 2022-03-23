package com.bselzer.gw2.v2.model.superadventurebox.unlock

import com.bselzer.gw2.v2.model.enumeration.wrapper.SabUnlockName
import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SabUnlock(
    /**
     * The id of the unlocked object.
     */
    @SerialName("id")
    override val id: SabUnlockId = SabUnlockId(),

    /**
     * The name of the upgrade.
     */
    @SerialName("name")
    val name: SabUnlockName = SabUnlockName()
) : Identifiable<Int>