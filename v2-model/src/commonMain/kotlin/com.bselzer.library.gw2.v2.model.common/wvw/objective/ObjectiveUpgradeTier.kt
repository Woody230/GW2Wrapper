package com.bselzer.library.gw2.v2.model.common.wvw.objective

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ObjectiveUpgradeTier(
    @SerialName("name")
    val name: String,

    @SerialName("yaks_required")
    val yaksRequired: Int = 0,

    @SerialName("upgrades")
    val upgrades: List<ObjectiveTierUpgrade> = emptyList()
)