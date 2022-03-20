package com.bselzer.gw2.v2.model.item.detail

import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgradeId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GizmoDetails(
    @SerialName("type")
    val type: String = "",

    /**
     * The id of the guild upgrade.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("guild_upgrade_id")
    val guildUpgradeId: GuildUpgradeId = GuildUpgradeId(),

    // TODO what is this id for
    @SerialName("vendor_ids")
    val vendorIds: List<Int> = emptyList()
)