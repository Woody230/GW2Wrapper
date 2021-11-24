package com.bselzer.library.gw2.v2.cache.instance

import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.gw2.v2.model.guild.Guild
import com.bselzer.library.gw2.v2.model.guild.GuildMember
import com.bselzer.library.gw2.v2.model.guild.GuildPermission
import com.bselzer.library.gw2.v2.model.guild.GuildRank
import com.bselzer.library.gw2.v2.model.guild.emblem.GuildEmblem
import com.bselzer.library.gw2.v2.model.guild.log.GuildLog
import com.bselzer.library.gw2.v2.model.guild.stash.GuildStash
import com.bselzer.library.gw2.v2.model.guild.storage.GuildStorageSlot
import com.bselzer.library.gw2.v2.model.guild.team.GuildTeam
import com.bselzer.library.gw2.v2.model.guild.treasury.GuildTreasurySlot
import com.bselzer.library.gw2.v2.model.guild.upgrade.GuildUpgrade
import com.bselzer.library.gw2.v2.model.guild.upgrade.cost.GuildUpgradeCost
import com.bselzer.library.kotlin.extension.kodein.db.operation.clear
import com.bselzer.library.kotlin.extension.kodein.db.operation.getById
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionManager

/**
 * Represents a cache for models related to a [Guild].
 */
class GuildCache(transactionManager: TransactionManager, client: Gw2Client) : Gw2Cache(transactionManager, client) {
    /**
     * Gets the guild with the given [id].
     *
     * If there is no guild in the database, then the api is called.
     *
     * @param id the id of the guild
     * @return the guild
     */
    suspend fun getGuild(id: String): Guild = transaction {
        getById(id, { client.guild.guild(id) })
    }

    override suspend fun clear() = transaction {
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