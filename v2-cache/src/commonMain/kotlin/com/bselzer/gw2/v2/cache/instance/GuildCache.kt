package com.bselzer.gw2.v2.cache.instance

import com.bselzer.gw2.v2.client.client.Gw2Client
import com.bselzer.gw2.v2.model.guild.Guild
import com.bselzer.gw2.v2.model.guild.GuildId
import com.bselzer.gw2.v2.model.guild.emblem.GuildEmblem
import com.bselzer.gw2.v2.model.guild.log.GuildLog
import com.bselzer.gw2.v2.model.guild.member.GuildMember
import com.bselzer.gw2.v2.model.guild.permission.GuildPermission
import com.bselzer.gw2.v2.model.guild.rank.GuildRank
import com.bselzer.gw2.v2.model.guild.stash.GuildStash
import com.bselzer.gw2.v2.model.guild.storage.GuildStorageSlot
import com.bselzer.gw2.v2.model.guild.team.GuildTeam
import com.bselzer.gw2.v2.model.guild.treasury.GuildTreasurySlot
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.cost.GuildUpgradeCost
import com.bselzer.ktx.kodein.db.cache.Cache
import com.bselzer.ktx.kodein.db.operation.clear
import com.bselzer.ktx.kodein.db.operation.getById
import com.bselzer.ktx.kodein.db.transaction.Transaction

/**
 * Represents a cache for models related to a [Guild].
 */
class GuildCache(private val client: Gw2Client) : Cache {
    /**
     * Gets the guild with the given [id].
     *
     * If there is no guild in the database, then the api is called.
     *
     * @param id the id of the guild
     * @return the guild
     */
    suspend fun Transaction.getGuild(id: GuildId): Guild {
        return getById(id, { client.guild.guild(id) })
    }

    override fun Transaction.clear() {
        clear<Guild>()
        clear<GuildLog>()
        clear<GuildMember>()
        clear<GuildRank>()
        clear<GuildStash>()
        clear<GuildStorageSlot>()
        clear<GuildEmblem>()
        clear<GuildTeam>()
        clear<GuildPermission>()
        clear<GuildTreasurySlot>()
        clear<GuildUpgrade>()
        clear<GuildUpgradeCost>()
    }
}