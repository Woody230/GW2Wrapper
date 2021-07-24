package com.bselzer.library.gw2.model.common.wvw.objective.upgrade

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ObjectiveUpgradeTier(
    @SerialName("name")
    val name: String,

    @SerialName("yaks_required")
    val yaksRequired: Int = 0,

    @SerialName("upgrades")
    val upgrades: List<TierUpgrade> = emptyList()
)