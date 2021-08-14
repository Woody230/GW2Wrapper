package com.bselzer.library.gw2.v2.model.common.item.detail

import com.bselzer.library.gw2.v2.model.common.item.detail.infix.InfixUpgrade
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpgradeComponentDetails(
    @SerialName("type")
    val type: String = "",

    /**
     * The flags indicating what type of items can be upgraded.
     */
    @SerialName("flags")
    val flags: List<String> = emptyList(),

    @SerialName("infusion_upgrade_flags")
    val infusionUpgradeFlags: List<String> = emptyList(),

    @SerialName("suffix")
    val suffix: String = "",

    @SerialName("infix_upgrade")
    val infixUpgrade: InfixUpgrade = InfixUpgrade(),

    /**
     * The effect bonuses if this component is for a rune. The [infixUpgrade] will not contain a buff.
     */
    @SerialName("bonuses")
    val bonuses: List<String> = emptyList()
)