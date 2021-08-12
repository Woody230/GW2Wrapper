package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Guilds
import com.bselzer.library.gw2.v2.model.common.guild.GuildEmblem
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The guild client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild">the wiki</a>
 */
class GuildClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available foreground emblems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/foregrounds">the wiki</a>
     */
    suspend fun foregroundEmblemIds(): List<Int> = httpClient.get(path = "${Guilds.EMBLEM}/${Guilds.FOREGROUNDS}")

    /**
     * @return the foreground emblems associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/foregrounds">the wiki</a>
     */
    suspend fun foregroundEmblems(ids: Collection<Int>): List<GuildEmblem> = chunkedIds(ids, "${Guilds.EMBLEM}/${Guilds.FOREGROUNDS}")

    /**
     * @return all the foreground emblems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/foregrounds">the wiki</a>
     */
    suspend fun foregroundEmblems(): List<GuildEmblem> = allIds("${Guilds.EMBLEM}/${Guilds.FOREGROUNDS}")

    /**
     * @return the ids of the available background emblems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/backgrounds">the wiki</a>
     */
    suspend fun backgroundEmblemIds(): List<Int> = httpClient.get(path = "${Guilds.EMBLEM}/${Guilds.BACKGROUNDS}")

    /**
     * @return the background emblems associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/backgrounds">the wiki</a>
     */
    suspend fun backgroundEmblems(ids: Collection<Int>): List<GuildEmblem> = chunkedIds(ids, "${Guilds.EMBLEM}/${Guilds.BACKGROUNDS}")

    /**
     * @return all the background emblems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/backgrounds">the wiki</a>
     */
    suspend fun backgroundEmblems(): List<GuildEmblem> = allIds("${Guilds.EMBLEM}/${Guilds.BACKGROUNDS}")
}