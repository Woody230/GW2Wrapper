package com.bselzer.library.gw2.v2.model.wvw.upgrade

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwUpgrade(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("tiers")
    val tiers: List<WvwUpgradeTier> = emptyList()
) : Identifiable<Int>