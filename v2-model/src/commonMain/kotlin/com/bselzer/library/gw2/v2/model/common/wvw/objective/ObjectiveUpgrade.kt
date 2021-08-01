package com.bselzer.library.gw2.v2.model.common.wvw.objective

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ObjectiveUpgrade(
    @SerialName("id")
    val id: Int,

    @SerialName("tiers")
    val tiers: List<ObjectiveUpgradeTier> = emptyList()
)