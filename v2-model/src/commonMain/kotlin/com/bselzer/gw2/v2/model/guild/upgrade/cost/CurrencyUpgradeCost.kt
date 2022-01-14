package com.bselzer.gw2.v2.model.guild.upgrade.cost

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Currency")
data class CurrencyUpgradeCost(
    @SerialName("name")
    val name: String = ""
) : GuildUpgradeCost()