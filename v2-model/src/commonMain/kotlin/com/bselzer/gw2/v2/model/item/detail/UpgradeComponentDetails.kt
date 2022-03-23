package com.bselzer.gw2.v2.model.item.detail

import com.bselzer.gw2.v2.model.item.detail.infix.InfixUpgrade
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpgradeComponentDetails(
    @SerialName("type")
    val type: com.bselzer.gw2.v2.model.wrapper.UpgradeComponentDetailType = com.bselzer.gw2.v2.model.wrapper.UpgradeComponentDetailType(),

    /**
     * The flags indicating what type of items can be upgraded.
     */
    @SerialName("flags")
    val flags: List<com.bselzer.gw2.v2.model.wrapper.UpgradeComponentFlag> = emptyList(),

    @SerialName("infusion_upgrade_flags")
    val infusionUpgradeFlags: List<com.bselzer.gw2.v2.model.wrapper.InfusionUpgradeFlag> = emptyList(),

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