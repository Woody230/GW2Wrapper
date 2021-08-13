package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.annotation.common.scope.*
import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Guilds
import com.bselzer.library.gw2.v2.client.common.extension.ensureBearer
import com.bselzer.library.gw2.v2.model.common.guild.Guild
import com.bselzer.library.gw2.v2.model.common.guild.GuildMember
import com.bselzer.library.gw2.v2.model.common.guild.GuildRank
import com.bselzer.library.gw2.v2.model.common.guild.log.GuildLog
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The guild client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild">the wiki</a>
 */
@Scope(Requirement.OPTIONAL, Permission.ACCOUNT, Permission.GUILDS)
class GuildClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the guild associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id">the wiki</a>
     */
    @GuildScope(Requirement.OPTIONAL, GuildRanking.LEADER, GuildRanking.MEMBER)
    @Scope(Requirement.OPTIONAL, Permission.GUILDS)
    suspend fun guild(id: String, token: String? = null): List<Guild> = httpClient.get(path = "${Guilds.GUILD}/${id}") {
        ensureBearer(token)
    }

    /**
     * @return the logs associated with the guild that has the given [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun logs(id: String, token: String? = null): List<GuildLog> = httpClient.get(path = "${Guilds.GUILD}/${id}/${Guilds.LOG}") {
        ensureBearer(token)
    }

    /**
     * @return the logs associated with the guild that has the given [id] with an id newer than the given [since] id
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun logs(id: String, since: Int, token: String? = null): List<GuildLog> = httpClient.get(path = "${Guilds.GUILD}/${id}/${Guilds.LOG}") {
        ensureBearer(token)
        parameter("since", since)
    }

    /**
     * @return the members of the guild associated with the given [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/members">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun members(id: String, token: String? = null): List<GuildMember> = httpClient.get(path = "${Guilds.GUILD}/${id}/${Guilds.MEMBERS}") {
        ensureBearer(token)
    }

    /**
     * @return the ranks of the guild associated with the given [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/ranks">the wiki</a>
     */
    @GuildScope(Requirement.REQUIRED, GuildRanking.LEADER)
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun ranks(id: String, token: String? = null): List<GuildRank> = httpClient.get(path = "${Guilds.GUILD}/${id}/${Guilds.RANKS}") {
        ensureBearer(token)
    }
}