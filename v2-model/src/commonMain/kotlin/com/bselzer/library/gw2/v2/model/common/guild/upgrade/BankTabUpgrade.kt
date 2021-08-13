package com.bselzer.library.gw2.v2.model.common.guild.upgrade

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The upgrade for guild banks.
 */
@Serializable
@SerialName("BankBag")
data class BankTabUpgrade(
    /**
     * The maximum number of item slots that can be stored in the bank tab.
     */
    @SerialName("bag_max_items")
    val maxSlots: Int = 0,

    /**
     * The maximum number of coins that can be stored in the bank tab.
     */
    @SerialName("bag_max_coins")
    val maxCoins: Int = 0
) : GuildUpgrade()