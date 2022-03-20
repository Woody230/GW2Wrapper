package com.bselzer.gw2.v2.model.guild.stash

import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgradeId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildStash(
    /**
     * The id of the upgrade that grants access to this section of the vault.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("upgrade_id")
    val upgradeId: GuildUpgradeId = GuildUpgradeId(),

    /**
     * The number of slots in this section of the vault.
     */
    @SerialName("size")
    val count: Int = 0,

    /**
     * The amount of copper coins deposited in this section of the vault.
     */
    @SerialName("coins")
    val coins: Int = 0,

    @SerialName("note")
    val description: String = "",

    /**
     * The items in the slots of this section of the vault.
     *
     * A slot is null if it is empty.
     */
    @SerialName("inventory")
    val slots: List<GuildStashSlot?> = emptyList()
)