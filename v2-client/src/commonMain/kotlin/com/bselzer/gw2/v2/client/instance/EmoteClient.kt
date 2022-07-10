package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.emote.Emote
import com.bselzer.gw2.v2.model.emote.EmoteId
import io.ktor.client.*

/**
 * The emote client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emotes">the wiki</a>
 */
class EmoteClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val EMOTES = "emotes"
    }

    /**
     * @return the ids of the available emotes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emotes">the wiki</a>
     */
    suspend fun ids(): List<EmoteId> = getIds(path = EMOTES)

    /**
     * @return the emote associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emotes">the wiki</a>
     */
    suspend fun emotes(id: EmoteId): Emote = getSingleById(id, EMOTES, instance = { Emote(id = it) })

    /**
     * @return the emotes associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emotes">the wiki</a>
     */
    suspend fun emotes(ids: Collection<EmoteId>): List<Emote> = chunkedIds(ids, EMOTES, instance = { Emote(id = it) })

    /**
     * @return all the emotes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/emotes">the wiki</a>
     */
    suspend fun emotes(): List<Emote> = allIds(EMOTES)
}