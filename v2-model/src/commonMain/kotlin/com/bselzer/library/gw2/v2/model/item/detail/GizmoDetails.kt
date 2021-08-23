package com.bselzer.library.gw2.v2.model.item.detail

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
    val guildUpgradeId: Int = 0,

    @SerialName("vendor_ids")
    val vendorIds: List<Int> = emptyList()
)