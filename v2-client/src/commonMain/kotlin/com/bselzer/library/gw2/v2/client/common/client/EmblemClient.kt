package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Emblems
import com.bselzer.library.gw2.v2.model.common.emblem.Emblem
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The emblem client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">the wiki</a>
 */
class EmblemClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of the available foreground emblems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/foregrounds">the wiki</a>
     */
    suspend fun foregroundEmblemIds(): List<Int> = httpClient.get(path = "${Emblems.EMBLEM}/${Emblems.FOREGROUNDS}")

    /**
     * @return the foreground emblems associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/foregrounds">the wiki</a>
     */
    suspend fun foregroundEmblems(ids: Collection<Int>): List<Emblem> = chunkedIds(ids, "${Emblems.EMBLEM}/${Emblems.FOREGROUNDS}")

    /**
     * @return all the foreground emblems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/foregrounds">the wiki</a>
     */
    suspend fun foregroundEmblems(): List<Emblem> = allIds("${Emblems.EMBLEM}/${Emblems.FOREGROUNDS}")

    /**
     * @return the ids of the available background emblems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/backgrounds">the wiki</a>
     */
    suspend fun backgroundEmblemIds(): List<Int> = httpClient.get(path = "${Emblems.EMBLEM}/${Emblems.BACKGROUNDS}")

    /**
     * @return the background emblems associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/backgrounds">the wiki</a>
     */
    suspend fun backgroundEmblems(ids: Collection<Int>): List<Emblem> = chunkedIds(ids, "${Emblems.EMBLEM}/${Emblems.BACKGROUNDS}")

    /**
     * @return all the background emblems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/backgrounds">the wiki</a>
     */
    suspend fun backgroundEmblems(): List<Emblem> = allIds("${Emblems.EMBLEM}/${Emblems.BACKGROUNDS}")
}