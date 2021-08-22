package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.wvw.ability.WvwAbility
import com.bselzer.library.gw2.v2.model.common.wvw.match.WvwMatch
import com.bselzer.library.gw2.v2.model.common.wvw.match.WvwMatchOverview
import com.bselzer.library.gw2.v2.model.common.wvw.match.WvwMatchScore
import com.bselzer.library.gw2.v2.model.common.wvw.match.WvwMatchStat
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

    /**
     * Adds the world id.
     */
    private fun HttpRequestBuilder.world(world: Int) = parameter("world", world)

    /**
     * @return a single object
     */
    private suspend inline fun <reified T> single(worldId: Int, basePath: String, block: HttpRequestBuilder.() -> Unit = {}): T =
        get(path = basePath) {
            world(worldId)
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
    suspend fun ability(id: Int, language: String? = null): WvwAbility = single(id, "${WVW}/${ABILITIES}") {
        language(language)
    }

    /**
     * @return the abilities associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilities(ids: Collection<Int>, language: String? = null): List<WvwAbility> = chunkedIds(ids, "${WVW}/${ABILITIES}") {
        language(language)
    }

    /**
     * @return all the abilities
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilities(language: String? = null): List<WvwAbility> = allIds("${WVW}/${ABILITIES}") {
        language(language)
    }

    /**
     * @return the ids of the available matches
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matchIds(): List<String> = get(path = "${WVW}/${MATCHES}")

    /**
     * @return the match associated with the [worldId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun match(worldId: Int): WvwMatch = single(worldId, "${WVW}/${MATCHES}")

    /**
     * @return the match associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun match(id: String): WvwMatch = single(id, "${WVW}/${MATCHES}")

    /**
     * @return the matches associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matches(ids: Collection<String>): List<WvwMatch> = chunkedIds(ids, "${WVW}/${MATCHES}")

    /**
     * @return all the matches
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matches(): List<WvwMatch> = allIds("${WVW}/${MATCHES}")

    /**
     * @return the ids of the available match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviewIds(): List<Int> = get(path = "${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return the match overview associated with the [worldId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overview(worldId: Int): WvwMatchOverview = single(worldId, "${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return the match overview associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overview(id: String): WvwMatchOverview = single(id, "${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return the match overviews associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviews(ids: Collection<String>): List<WvwMatchOverview> = chunkedIds(ids, "${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return all the match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviews(): List<WvwMatchOverview> = allIds("${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return the ids of the available match scores
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scoreIds(): List<Int> = get(path = "${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return the match score associated with the [worldId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun score(worldId: Int): WvwMatchScore = single(worldId, "${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return the match score associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun score(id: String): WvwMatchScore = single(id, "${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return the match scores associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scores(ids: Collection<String>): List<WvwMatchScore> = chunkedIds(ids, "${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return all the match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scores(): List<WvwMatchScore> = allIds("${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return the ids of the available match stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun statIds(): List<String> = get(path = "${WVW}/${MATCHES}/${STATS}")

    /**
     * @return the match stat associated with the [worldId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stat(worldId: Int): WvwMatchStat = single(worldId, "${WVW}/${MATCHES}/${STATS}")

    /**
     * @return the match stat associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stat(id: String): WvwMatchStat = single(id, "${WVW}/${MATCHES}/${STATS}")

    /**
     * @return the match stats associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stats(ids: Collection<String>): List<WvwMatchStat> = chunkedIds(ids, "${WVW}/${MATCHES}/${STATS}")

    /**
     * @return all the match stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stats(): List<WvwMatchStat> = allIds("${WVW}/${MATCHES}/${STATS}")

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