package com.bselzer.library.gw2.v2.model.common.guild.treasury

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TreasuryUpgrade(
    /**
     * The id of the upgrade.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("upgrade_id")
    val upgradeId: Int = 0,

    /**
     * The number of the item required.
     */
    @SerialName("count")
    val count: Int = 0,
)