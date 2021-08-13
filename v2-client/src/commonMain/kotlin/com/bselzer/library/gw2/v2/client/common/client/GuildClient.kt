package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.annotation.common.scope.*
import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Guilds
import com.bselzer.library.gw2.v2.client.common.extension.ensureBearer
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.guild.Guild
import com.bselzer.library.gw2.v2.model.common.guild.GuildMember
import com.bselzer.library.gw2.v2.model.common.guild.GuildPermission
import com.bselzer.library.gw2.v2.model.common.guild.GuildRank
import com.bselzer.library.gw2.v2.model.common.guild.log.GuildLog
import com.bselzer.library.gw2.v2.model.common.guild.stash.GuildStash
import com.bselzer.library.gw2.v2.model.common.guild.storage.GuildStorageSlot
import com.bselzer.library.gw2.v2.model.common.guild.team.GuildTeam
import com.bselzer.library.gw2.v2.model.common.guild.upgrade.GuildUpgrade
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The guild client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild">the wiki</a>
 */
@GuildScope(Requirement.OPTIONAL, GuildRanking.LEADER, GuildRanking.MEMBER)
@Scope(Requirement.OPTIONAL, Permission.ACCOUNT, Permission.GUILDS)
class GuildClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the guild associated with the [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id">the wiki</a>
     */
    @GuildScope(Requirement.OPTIONAL, GuildRanking.LEADER, GuildRanking.MEMBER)
    @Scope(Requirement.OPTIONAL, Permission.GUILDS)
    suspend fun guild(guildId: String, token: String? = null): List<Guild> = httpClient.get(path = "${Guilds.GUILD}/${guildId}") {
        ensureBearer(token)
    }

    /**
     * @return the logs associated with the guild that has the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun logs(guildId: String, token: String? = null): List<GuildLog> = httpClient.get(path = "${Guilds.GUILD}/${guildId}/${Guilds.LOG}") {
        ensureBearer(token)
    }

    /**
     * @return the logs associated with the guild that has the given [guildId] with an id newer than the given [since] id
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun logs(guildId: String, since: Int, token: String? = null): List<GuildLog> = httpClient.get(path = "${Guilds.GUILD}/${guildId}/${Guilds.LOG}") {
        ensureBearer(token)
        parameter("since", since)
    }

    /**
     * @return the members of the guild associated with the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/members">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun members(guildId: String, token: String? = null): List<GuildMember> = httpClient.get(path = "${Guilds.GUILD}/${guildId}/${Guilds.MEMBERS}") {
        ensureBearer(token)
    }

    /**
     * @return the ranks of the guild associated with the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/ranks">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun ranks(guildId: String, token: String? = null): List<GuildRank> = httpClient.get(path = "${Guilds.GUILD}/${guildId}/${Guilds.RANKS}") {
        ensureBearer(token)
    }

    /**
     * @return the stashes in the vault of the guild associated with the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/stash">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun stashes(guildId: String, token: String? = null): List<GuildStash> = httpClient.get(path = "${Guilds.GUILD}/${guildId}/${Guilds.STASH}") {
        ensureBearer(token)
    }

    /**
     * @return the storage slots of the guild associated with the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/storage">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun storageSlots(guildId: String, token: String? = null): List<GuildStorageSlot> = httpClient.get(path = "${Guilds.GUILD}/${guildId}/${Guilds.STASH}") {
        ensureBearer(token)
    }

    /**
     * @return the teams of the guild associated with the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/teams">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun teams(guildId: String, token: String? = null): List<GuildTeam> = httpClient.get(path = "${Guilds.GUILD}/${guildId}/${Guilds.TEAMS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked upgrades of the guild associated with the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/upgrades">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun upgradeIds(guildId: String, token: String? = null): List<Int> = httpClient.get(path = "${Guilds.GUILD}/${guildId}/${Guilds.UPGRADES}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the available permissions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">the wiki</a>
     */
    suspend fun permissionIds(): List<String> = httpClient.get(path = "${Guilds.GUILD}/${Guilds.PERMISSIONS}")

    /**
     * @return the permissions associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">the wiki</a>
     */
    suspend fun permissions(ids: Collection<String>, language: String? = null): List<GuildPermission> = chunkedIds(ids, "${Guilds.GUILD}/${Guilds.PERMISSIONS}") {
        language(language)
    }

    /**
     * @return all the permissions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">the wiki</a>
     */
    suspend fun permissions(language: String? = null): List<GuildPermission> = allIds("${Guilds.GUILD}/${Guilds.PERMISSIONS}") {
        language(language)
    }

    /**
     * @return the id, in the form of a UUID, of the guild with the given [name]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/search">the wiki</a>
     */
    suspend fun search(name: String): String? = httpClient.get<List<String>>(path = "${Guilds.GUILD}/${Guilds.SEARCH}") {
        parameter("name", name)
    }.firstOrNull()

    /**
     * @return the ids of the available upgrades
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    suspend fun upgradeIds(): List<Int> = httpClient.get(path = "${Guilds.GUILD}/${Guilds.UPGRADES}")

    /**
     * @return the upgrades associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    suspend fun upgrades(ids: Collection<Int>, language: String? = null): List<GuildUpgrade> = chunkedIds(ids, "${Guilds.GUILD}/${Guilds.UPGRADES}") {
        language(language)
    }

    /**
     * @return all the upgrades
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    suspend fun upgrades(language: String? = null): List<GuildUpgrade> = allIds("${Guilds.GUILD}/${Guilds.UPGRADES}") {
        language(language)
    }
}