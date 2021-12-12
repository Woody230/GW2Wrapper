package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.model.emblem.Emblem
import io.ktor.client.*

/**
 * The emblem client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem">the wiki</a>
 */
class EmblemClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
        const val EMBLEM = "emblem"
        const val FOREGROUNDS = "foregrounds"
        const val BACKGROUNDS = "backgrounds"
    }

    /**
     * @return the ids of the available foreground emblems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/foregrounds">the wiki</a>
     */
    suspend fun foregroundEmblemIds(): List<Int> = getList(path = "${EMBLEM}/${FOREGROUNDS}")

    /**
     * @return the foreground emblem associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/foregrounds">the wiki</a>
     */
    suspend fun foregroundEmblem(id: Int): Emblem = getSingleById(id, "${EMBLEM}/${FOREGROUNDS}")

    /**
     * @return the foreground emblems associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/foregrounds">the wiki</a>
     */
    suspend fun foregroundEmblems(ids: Collection<Int>): List<Emblem> = chunkedIds(ids, "${EMBLEM}/${FOREGROUNDS}")

    /**
     * @return all the foreground emblems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/foregrounds">the wiki</a>
     */
    suspend fun foregroundEmblems(): List<Emblem> = allIds("${EMBLEM}/${FOREGROUNDS}")

    /**
     * @return the ids of the available background emblems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/backgrounds">the wiki</a>
     */
    suspend fun backgroundEmblemIds(): List<Int> = getList(path = "${EMBLEM}/${BACKGROUNDS}")

    /**
     * @return the background emblem associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/backgrounds">the wiki</a>
     */
    suspend fun backgroundEmblem(id: Int): Emblem = getSingleById(id, "${EMBLEM}/${BACKGROUNDS}")

    /**
     * @return the background emblems associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/backgrounds">the wiki</a>
     */
    suspend fun backgroundEmblems(ids: Collection<Int>): List<Emblem> = chunkedIds(ids, "${EMBLEM}/${BACKGROUNDS}")

    /**
     * @return all the background emblems
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emblem/backgrounds">the wiki</a>
     */
    suspend fun backgroundEmblems(): List<Emblem> = allIds("${EMBLEM}/${BACKGROUNDS}")
}