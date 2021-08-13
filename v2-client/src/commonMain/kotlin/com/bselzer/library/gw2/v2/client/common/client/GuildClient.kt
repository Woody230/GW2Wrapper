package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Guilds
import com.bselzer.library.gw2.v2.client.common.extension.ensureBearer
import com.bselzer.library.gw2.v2.model.common.guild.Guild
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
    @Scope(Requirement.OPTIONAL, Permission.GUILDS)
    suspend fun guild(id: String, token: String? = null): List<Guild> = httpClient.get(path = "${Guilds.GUILD}/${id}") {
        ensureBearer(token)
    }

    /**
     * @return the logs associated with the guild that has the given [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun logs(id: String, token: String? = null): List<GuildLog> = httpClient.get(path = "${Guilds.GUILD}/${id}/${Guilds.LOG}") {
        ensureBearer(token)
    }

    /**
     * @return the logs associated with the guild that has the given [id] with an id newer than the given [since] id
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id/log">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.GUILDS)
    suspend fun logs(id: String, since: Int, token: String? = null): List<GuildLog> = httpClient.get(path = "${Guilds.GUILD}/${id}/${Guilds.LOG}") {
        ensureBearer(token)
        parameter("since", since)
    }


}