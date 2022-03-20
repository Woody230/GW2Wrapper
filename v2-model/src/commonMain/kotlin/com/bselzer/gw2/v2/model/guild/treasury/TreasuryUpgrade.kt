package com.bselzer.gw2.v2.model.guild.treasury

import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgradeId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TreasuryUpgrade(
    /**
     * The id of the upgrade.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("upgrade_id")
    val upgradeId: GuildUpgradeId = GuildUpgradeId(),

    /**
     * The number of the item required.
     */
    @SerialName("count")
    val count: Int = 0,
)