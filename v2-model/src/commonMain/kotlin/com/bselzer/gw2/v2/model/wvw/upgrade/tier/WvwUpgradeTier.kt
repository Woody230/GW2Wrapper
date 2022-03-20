package com.bselzer.gw2.v2.model.wvw.upgrade.tier

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwUpgradeTier(
    @SerialName("name")
    val name: String = "",

    @SerialName("yaks_required")
    val yaksRequired: Int = 0,

    @SerialName("upgrades")
    val upgrades: List<WvwTierUpgrade> = emptyList()
)