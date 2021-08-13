package com.bselzer.library.gw2.v2.model.common.guild.upgrade.cost

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Currency")
data class CurrencyUpgradeCost(
    @SerialName("name")
    val name: String = ""
) : GuildUpgradeCost()