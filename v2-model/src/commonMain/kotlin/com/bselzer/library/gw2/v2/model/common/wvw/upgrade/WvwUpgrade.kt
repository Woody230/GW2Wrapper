package com.bselzer.library.gw2.v2.model.common.wvw.upgrade

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwUpgrade(
    @SerialName("id")
    val id: Int,

    @SerialName("tiers")
    val tiers: List<WvwUpgradeTier> = emptyList()
)