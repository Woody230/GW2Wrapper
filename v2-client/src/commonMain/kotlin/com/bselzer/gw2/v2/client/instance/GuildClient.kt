package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.bearer
import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.client.model.Token
import com.bselzer.gw2.v2.model.guild.Guild
import com.bselzer.gw2.v2.model.guild.GuildId
import com.bselzer.gw2.v2.model.guild.log.GuildLog
import com.bselzer.gw2.v2.model.guild.log.GuildLogId
import com.bselzer.gw2.v2.model.guild.member.GuildMember
import com.bselzer.gw2.v2.model.guild.permission.GuildPermission
import com.bselzer.gw2.v2.model.guild.permission.GuildPermissionId
import com.bselzer.gw2.v2.model.guild.rank.GuildRank
import com.bselzer.gw2.v2.model.guild.stash.GuildStash
import com.bselzer.gw2.v2.model.guild.storage.GuildStorageSlot
import com.bselzer.gw2.v2.model.guild.team.GuildTeam
import com.bselzer.gw2.v2.model.guild.treasury.GuildTreasurySlot
import com.bselzer.gw2.v2.model.guild.upgrade.DefaultUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgradeId
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import com.bselzer.gw2.v2.scope.guild.GuildRanking
import com.bselzer.gw2.v2.scope.guild.GuildScope
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The guild client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild">the wiki</a>
 */
@GuildScope(Requirement.OPTIONAL, GuildRanking.LEADER, GuildRanking.MEMBER)
@Scope(Requirement.OPTIONAL, Permission.ACCOUNT, Permission.GUILDS)
class GuildClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val GUILD = "guild"
        const val LOG = "log"
        const val MEMBERS = "members"
        const val RANKS = "ranks"
        const val STASH = "stash"
        const val TEAMS = "teams"
        const val UPGRADES = "upgrades"
        const val PERMISSIONS = "permissions"
        const val SEARCH = "search"
        const val TREASURY = "treasury"
    }

    /**
     * @return the guild associated with the [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id">the wiki</a>
     */
    @GuildScope(Requirement.OPTIONAL, GuildRanking.LEADER, GuildRanking.MEMBER)
    @Scope(Requirement.OPTIONAL, Permission.GUILDS)
    suspend fun guild(guildId: GuildId, token: Token? = null): Guild = getIdentifiableSingle(guildId, path = "${GUILD}/${guildId}", instance = { Guild(id = it) }) {
        bearer(token)
    }

    /**
     * @return the logs associated with the guild that has the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun logs(guildId: GuildId, token: Token? = null): List<GuildLog> = getList(path = "${GUILD}/${guildId}/${LOG}") {
        bearer(token)
    }

    /**
     * @return the logs associated with the guild that has the given [guildId] with an id newer than the given [since] id
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun logs(guildId: GuildId, since: GuildLogId, token: Token? = null): List<GuildLog> = getList(path = "${GUILD}/${guildId}/${LOG}") {
        bearer(token)
        parameter("since", since)
    }

    /**
     * @return the members of the guild associated with the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/members">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun members(guildId: GuildId, token: Token? = null): List<GuildMember> = getList(path = "${GUILD}/${guildId}/${MEMBERS}") {
        bearer(token)
    }

    /**
     * @return the ranks of the guild associated with the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/ranks">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun ranks(guildId: GuildId, token: Token? = null): List<GuildRank> = getList(path = "${GUILD}/${guildId}/${RANKS}") {
        bearer(token)
    }

    /**
     * @return the stashes in the vault of the guild associated with the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/stash">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun stashes(guildId: GuildId, token: Token? = null): List<GuildStash> = getList(path = "${GUILD}/${guildId}/${STASH}") {
        bearer(token)
    }

    /**
     * @return the storage slots of the guild associated with the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/storage">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun storageSlots(guildId: GuildId, token: Token? = null): List<GuildStorageSlot> = getList(path = "${GUILD}/${guildId}/${STASH}") {
        bearer(token)
    }

    /**
     * @return the teams of the guild associated with the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/teams">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun teams(guildId: GuildId, token: Token? = null): List<GuildTeam> = getList(path = "${GUILD}/${guildId}/${TEAMS}") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked upgrades of the guild associated with the given [guildId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/upgrades">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun upgradeIds(guildId: GuildId, token: Token? = null): List<GuildUpgradeId> = getList(path = "${GUILD}/${guildId}/${UPGRADES}") {
        bearer(token)
    }

    /**
     * @return the ids of the available permissions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">the wiki</a>
     */
    suspend fun permissionIds(): List<GuildPermissionId> = getIds(path = "${GUILD}/${PERMISSIONS}")

    /**
     * @return the permission associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">the wiki</a>
     */
    suspend fun permission(id: GuildPermissionId, language: Language? = null): GuildPermission =
        getSingleById(id, "${GUILD}/${PERMISSIONS}", instance = { GuildPermission(id = it) }) {
            language(language)
        }

    /**
     * @return the permissions associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">the wiki</a>
     */
    suspend fun permissions(ids: Collection<GuildPermissionId>, language: Language? = null): List<GuildPermission> =
        chunkedIds(ids, "${GUILD}/${PERMISSIONS}", instance = { GuildPermission(id = it) }) {
            language(language)
        }

    /**
     * @return all the permissions
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/permissions">the wiki</a>
     */
    suspend fun permissions(language: Language? = null): List<GuildPermission> = allIds("${GUILD}/${PERMISSIONS}") {
        language(language)
    }

    /**
     * @return the ids, in the form of a UUID, of the guild with the given [name]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/search">the wiki</a>
     */
    suspend fun search(name: String): List<GuildId> = getList(path = "${GUILD}/${SEARCH}") {
        parameter("name", name)
    }

    /**
     * @return the ids of the available upgrades
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    suspend fun upgradeIds(): List<GuildUpgradeId> = getIds(path = "${GUILD}/${UPGRADES}")

    /**
     * @return the upgrade associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    suspend fun upgrade(id: GuildUpgradeId, language: Language? = null): GuildUpgrade =
        getSingleById(id, "${GUILD}/${UPGRADES}", instance = { DefaultUpgrade(identifier = it) }) {
            language(language)
        }

    /**
     * @return the upgrades associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    suspend fun upgrades(ids: Collection<GuildUpgradeId>, language: Language? = null): List<GuildUpgrade> =
        chunkedIds(ids, "${GUILD}/${UPGRADES}", instance = { DefaultUpgrade(identifier = it) }) {
            language(language)
        }

    /**
     * @return all the upgrades
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    suspend fun upgrades(language: Language? = null): List<GuildUpgrade> = allIds("${GUILD}/${UPGRADES}") {
        language(language)
    }

    /**
     * @return all the treasury slots
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/treasury">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun treasury(guildId: GuildId, token: Token? = null): List<GuildTreasurySlot> = getList(path = "${GUILD}/${guildId}/${TREASURY}") {
        bearer(token)
    }
}