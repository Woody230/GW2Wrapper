package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.model.common.emote.Emote
import io.ktor.client.*

/**
 * The emote client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emotes">the wiki</a>
 */
class EmoteClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val EMOTES = "emotes"
    }

    /**
     * @return the ids of the available emotes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emotes">the wiki</a>
     */
    suspend fun ids(): List<String> = get(path = EMOTES)

    /**
     * @return the emote associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emotes">the wiki</a>
     */
    suspend fun emotes(id: String): Emote = single(id, EMOTES)

    /**
     * @return the emotes associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emotes">the wiki</a>
     */
    suspend fun emotes(ids: Collection<String>): List<Emote> = chunkedIds(ids, EMOTES)

    /**
     * @return all the emotes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emotes">the wiki</a>
     */
    suspend fun emotes(): List<Emote> = allIds(EMOTES)
}