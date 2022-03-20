package com.bselzer.gw2.v2.model.wvw.upgrade

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.wvw.upgrade.tier.WvwUpgradeTier
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwUpgrade(
    @SerialName("id")
    override val id: WvwUpgradeId = WvwUpgradeId(),

    @SerialName("tiers")
    val tiers: List<WvwUpgradeTier> = emptyList()
) : Identifiable<Int>