package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.WvW
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.wvw.ability.Ability
import com.bselzer.library.gw2.v2.model.common.wvw.match.Match
import com.bselzer.library.gw2.v2.model.common.wvw.match.MatchOverview
import com.bselzer.library.gw2.v2.model.common.wvw.match.MatchScore
import com.bselzer.library.gw2.v2.model.common.wvw.match.MatchStat
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The world vs. world client.
 * @see <a href='https://wiki.guildwars2.com/wiki/API:2/wvw">the wiki</a>
 */
class WvwClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    @JvmInline
    value class World(val id: Int)

    /**
     * Adds the world id.
     */
    private fun HttpRequestBuilder.world(world: World) = parameter("world", world.id)

    /**
     * @return a single object
     */
    private suspend inline fun <reified T> single(world: World, basePath: String, block: HttpRequestBuilder.() -> Unit = {}): T =
        httpClient.get(path = basePath) {
            world(world)
            apply(block)
        }

    /**
     * @return the ids of the available abilities
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilityIds(): List<Int> = httpClient.get(path = "${WvW.WVW}/${WvW.ABILITIES}")

    /**
     * @return the ability associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun ability(id: Int, language: String? = null): Ability = single(id, "${WvW.WVW}/${WvW.ABILITIES}") {
        language(language)
    }

    /**
     * @return the abilities associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilities(ids: Collection<Int>, language: String? = null): List<Ability> = chunkedIds(ids, "${WvW.WVW}/${WvW.ABILITIES}") {
        language(language)
    }

    /**
     * @return all the abilities
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilities(language: String? = null): List<Ability> = allIds("${WvW.WVW}/${WvW.ABILITIES}") {
        language(language)
    }

    /**
     * @return the ids of the available matches
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matchIds(): List<Int> = httpClient.get(path = "${WvW.WVW}/${WvW.MATCHES}")

    /**
     * @return the match associated with the [World.id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun match(world: World): Match = single(world, "${WvW.WVW}/${WvW.MATCHES}")

    /**
     * @return the match associated with the [World.id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun match(id: Int): Match = single(id, "${WvW.WVW}/${WvW.MATCHES}")

    /**
     * @return the matches associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matches(ids: Collection<Int>): List<Match> = chunkedIds(ids, "${WvW.WVW}/${WvW.MATCHES}")

    /**
     * @return all the matches
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matches(): List<Match> = allIds("${WvW.WVW}/${WvW.MATCHES}")

    /**
     * @return the ids of the available match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviewIds(): List<Int> = httpClient.get(path = "${WvW.WVW}/${WvW.MATCHES}/${WvW.OVERVIEW}")

    /**
     * @return the match overview associated with the [World.id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overview(world: World): MatchOverview = single(world, "${WvW.WVW}/${WvW.MATCHES}/${WvW.OVERVIEW}")

    /**
     * @return the match overview associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overview(id: Int): List<MatchOverview> = single(id, "${WvW.WVW}/${WvW.MATCHES}/${WvW.OVERVIEW}")

    /**
     * @return the match overviews associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviews(ids: Collection<Int>): List<MatchOverview> = chunkedIds(ids, "${WvW.WVW}/${WvW.MATCHES}/${WvW.OVERVIEW}")

    /**
     * @return all the match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviews(): List<MatchOverview> = allIds("${WvW.WVW}/${WvW.MATCHES}/${WvW.OVERVIEW}")

    /**
     * @return the ids of the available match scores
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scoreIds(): List<Int> = httpClient.get(path = "${WvW.WVW}/${WvW.MATCHES}/${WvW.SCORES}")

    /**
     * @return the match score associated with the [World.id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun score(world: World): MatchScore = single(world, "${WvW.WVW}/${WvW.MATCHES}/${WvW.SCORES}")

    /**
     * @return the match score associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun score(id: Int): List<MatchScore> = single(id, "${WvW.WVW}/${WvW.MATCHES}/${WvW.SCORES}")

    /**
     * @return the match scores associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scores(ids: Collection<Int>): List<MatchScore> = chunkedIds(ids, "${WvW.WVW}/${WvW.MATCHES}/${WvW.SCORES}")

    /**
     * @return all the match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scores(): List<MatchScore> = allIds("${WvW.WVW}/${WvW.MATCHES}/${WvW.SCORES}")

    /**
     * @return the ids of the available match stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun statIds(): List<Int> = httpClient.get(path = "${WvW.WVW}/${WvW.MATCHES}/${WvW.STATS}")

    /**
     * @return the match stat associated with the [World.id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stat(world: World): MatchStat = single(world, "${WvW.WVW}/${WvW.MATCHES}/${WvW.STATS}")

    /**
     * @return the match stat associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stat(id: Int): List<MatchStat> = single(id, "${WvW.WVW}/${WvW.MATCHES}/${WvW.STATS}")

    /**
     * @return the match stats associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stats(ids: Collection<Int>): List<MatchStat> = chunkedIds(ids, "${WvW.WVW}/${WvW.MATCHES}/${WvW.STATS}")

    /**
     * @return all the match stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stats(): List<MatchStat> = allIds("${WvW.WVW}/${WvW.MATCHES}/${WvW.STATS}")
}