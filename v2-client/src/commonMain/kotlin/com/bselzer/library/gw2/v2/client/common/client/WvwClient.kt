package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.wvw.ability.Ability
import com.bselzer.library.gw2.v2.model.common.wvw.match.Match
import com.bselzer.library.gw2.v2.model.common.wvw.match.MatchOverview
import com.bselzer.library.gw2.v2.model.common.wvw.match.MatchScore
import com.bselzer.library.gw2.v2.model.common.wvw.match.MatchStat
import com.bselzer.library.gw2.v2.model.common.wvw.objective.WvwObjective
import com.bselzer.library.gw2.v2.model.common.wvw.rank.WvwRank
import com.bselzer.library.gw2.v2.model.common.wvw.upgrade.WvwUpgrade
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The world vs. world client.
 * @see <a href='https://wiki.guildwars2.com/wiki/API:2/wvw">the wiki</a>
 */
class WvwClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val WVW = "wvw"
        const val ABILITIES = "abilities"
        const val MATCHES = "matches"
        const val OVERVIEW = "overview"
        const val SCORES = "scores"
        const val STATS = "stats"
        const val OBJECTIVES = "objectives"
        const val RANKS = "ranks"
        const val UPGRADES = "upgrades"
    }

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
        get(path = basePath) {
            world(world)
            apply(block)
        }

    /**
     * @return the ids of the available abilities
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilityIds(): List<Int> = get(path = "${WVW}/${ABILITIES}")

    /**
     * @return the ability associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun ability(id: Int, language: String? = null): Ability = single(id, "${WVW}/${ABILITIES}") {
        language(language)
    }

    /**
     * @return the abilities associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilities(ids: Collection<Int>, language: String? = null): List<Ability> = chunkedIds(ids, "${WVW}/${ABILITIES}") {
        language(language)
    }

    /**
     * @return all the abilities
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilities(language: String? = null): List<Ability> = allIds("${WVW}/${ABILITIES}") {
        language(language)
    }

    /**
     * @return the ids of the available matches
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matchIds(): List<Int> = get(path = "${WVW}/${MATCHES}")

    /**
     * @return the match associated with the [World.id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun match(world: World): Match = single(world, "${WVW}/${MATCHES}")

    /**
     * @return the match associated with the [World.id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun match(id: Int): Match = single(id, "${WVW}/${MATCHES}")

    /**
     * @return the matches associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matches(ids: Collection<Int>): List<Match> = chunkedIds(ids, "${WVW}/${MATCHES}")

    /**
     * @return all the matches
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matches(): List<Match> = allIds("${WVW}/${MATCHES}")

    /**
     * @return the ids of the available match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviewIds(): List<Int> = get(path = "${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return the match overview associated with the [World.id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overview(world: World): MatchOverview = single(world, "${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return the match overview associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overview(id: Int): MatchOverview = single(id, "${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return the match overviews associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviews(ids: Collection<Int>): List<MatchOverview> = chunkedIds(ids, "${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return all the match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviews(): List<MatchOverview> = allIds("${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return the ids of the available match scores
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scoreIds(): List<Int> = get(path = "${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return the match score associated with the [World.id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun score(world: World): MatchScore = single(world, "${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return the match score associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun score(id: Int): MatchScore = single(id, "${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return the match scores associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scores(ids: Collection<Int>): List<MatchScore> = chunkedIds(ids, "${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return all the match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scores(): List<MatchScore> = allIds("${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return the ids of the available match stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun statIds(): List<Int> = get(path = "${WVW}/${MATCHES}/${STATS}")

    /**
     * @return the match stat associated with the [World.id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stat(world: World): MatchStat = single(world, "${WVW}/${MATCHES}/${STATS}")

    /**
     * @return the match stat associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stat(id: Int): MatchStat = single(id, "${WVW}/${MATCHES}/${STATS}")

    /**
     * @return the match stats associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stats(ids: Collection<Int>): List<MatchStat> = chunkedIds(ids, "${WVW}/${MATCHES}/${STATS}")

    /**
     * @return all the match stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stats(): List<MatchStat> = allIds("${WVW}/${MATCHES}/${STATS}")

    /**
     * @return the ids of the available objectives
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    suspend fun objectiveIds(): List<String> = get(path = "${WVW}/${OBJECTIVES}")

    /**
     * @return the objective associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    suspend fun objective(id: String, language: String? = null): WvwObjective = single(id, "${WVW}/${OBJECTIVES}") {
        language(language)
    }

    /**
     * @return the objectives associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    suspend fun objectives(ids: Collection<String>, language: String? = null): List<WvwObjective> = chunkedIds(ids, "${WVW}/${OBJECTIVES}") {
        language(language)
    }

    /**
     * @return all the objectives
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    suspend fun objectives(language: String? = null): List<WvwObjective> = allIds("${WVW}/${OBJECTIVES}") {
        language(language)
    }

    /**
     * @return the ids of the available ranks
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">the wiki</a>
     */
    suspend fun rankIds(): List<Int> = get(path = "${WVW}/${RANKS}")

    /**
     * @return the rank associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">the wiki</a>
     */
    suspend fun rank(id: Int, language: String? = null): WvwRank = single(id, "${WVW}/${RANKS}") {
        language(language)
    }

    /**
     * @return the ranks associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">the wiki</a>
     */
    suspend fun ranks(ids: Collection<Int>, language: String? = null): List<WvwRank> = chunkedIds(ids, "${WVW}/${RANKS}") {
        language(language)
    }

    /**
     * @return all the ranks
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">the wiki</a>
     */
    suspend fun ranks(language: String? = null): List<WvwRank> = allIds("${WVW}/${RANKS}") {
        language(language)
    }

    /**
     * @return the ids of the available upgrades
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">the wiki</a>
     */
    suspend fun upgradeIds(): List<Int> = get(path = "${WVW}/${UPGRADES}")

    /**
     * @return the upgrade associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">the wiki</a>
     */
    suspend fun upgrade(id: Int, language: String? = null): WvwUpgrade = single(id, "${WVW}/${UPGRADES}") {
        language(language)
    }

    /**
     * @return the upgrades associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">the wiki</a>
     */
    suspend fun upgrades(ids: Collection<Int>, language: String? = null): List<WvwUpgrade> = chunkedIds(ids, "${WVW}/${UPGRADES}") {
        language(language)
    }

    /**
     * @return all the upgrades
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">the wiki</a>
     */
    suspend fun upgrades(language: String? = null): List<WvwUpgrade> = allIds("${WVW}/${UPGRADES}") {
        language(language)
    }
}