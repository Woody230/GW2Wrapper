package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.model.wvw.ability.WvwAbility
import com.bselzer.gw2.v2.model.wvw.match.WvwMatch
import com.bselzer.gw2.v2.model.wvw.match.WvwMatchOverview
import com.bselzer.gw2.v2.model.wvw.match.WvwMatchScore
import com.bselzer.gw2.v2.model.wvw.match.WvwMatchStat
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.gw2.v2.model.wvw.rank.WvwRank
import com.bselzer.gw2.v2.model.wvw.upgrade.WvwUpgrade
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The world vs. world client.
 * @see <a href='https://wiki.guildwars2.com/wiki/API:2/wvw">the wiki</a>
 */
class WvwClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
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
    private suspend inline fun <reified T> getSingleByWorld(worldId: Int, basePath: String, instance: () -> T, block: HttpRequestBuilder.() -> Unit = {}): T =
        getSingle(path = basePath, instance = instance) {
            world(worldId)
            apply(block)
        }

    /**
     * @return the ids of the available abilities
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilityIds(): List<Int> = getList(path = "${WVW}/${ABILITIES}")

    /**
     * @return the ability associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun ability(id: Int, language: String? = null): WvwAbility = getSingleById(id, "${WVW}/${ABILITIES}", instance = { WvwAbility(id = it) }) {
        language(language)
    }

    /**
     * @return the abilities associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilities(ids: Collection<Int>, language: String? = null): List<WvwAbility> = chunkedIds(ids, "${WVW}/${ABILITIES}", instance = { WvwAbility(id = it) }) {
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
    suspend fun matchIds(): List<String> = getList(path = "${WVW}/${MATCHES}")

    /**
     * @return the match associated with the [worldId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun match(worldId: Int): WvwMatch = getSingleByWorld(worldId, "${WVW}/${MATCHES}", instance = { WvwMatch() })

    /**
     * @return the match associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun match(id: String): WvwMatch = getSingleById(id, "${WVW}/${MATCHES}", instance = { WvwMatch(id = it) })

    /**
     * @return the matches associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matches(ids: Collection<String>): List<WvwMatch> = chunkedIds(ids, "${WVW}/${MATCHES}", instance = { WvwMatch(id = it) })

    /**
     * @return all the matches
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matches(): List<WvwMatch> = allIds("${WVW}/${MATCHES}")

    /**
     * @return the ids of the available match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviewIds(): List<Int> = getList(path = "${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return the match overview associated with the [worldId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overview(worldId: Int): WvwMatchOverview = getSingleByWorld(worldId, "${WVW}/${MATCHES}/${OVERVIEW}", instance = { WvwMatchOverview() })

    /**
     * @return the match overview associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overview(id: String): WvwMatchOverview = getSingleById(id, "${WVW}/${MATCHES}/${OVERVIEW}", instance = { WvwMatchOverview(id = it) })

    /**
     * @return the match overviews associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviews(ids: Collection<String>): List<WvwMatchOverview> = chunkedIds(ids, "${WVW}/${MATCHES}/${OVERVIEW}", instance = { WvwMatchOverview(id = it) })

    /**
     * @return all the match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviews(): List<WvwMatchOverview> = allIds("${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return the ids of the available match scores
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scoreIds(): List<Int> = getList(path = "${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return the match score associated with the [worldId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun score(worldId: Int): WvwMatchScore = getSingleByWorld(worldId, "${WVW}/${MATCHES}/${SCORES}", instance = { WvwMatchScore() })

    /**
     * @return the match score associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun score(id: String): WvwMatchScore = getSingleById(id, "${WVW}/${MATCHES}/${SCORES}", instance = { WvwMatchScore(id = it) })

    /**
     * @return the match scores associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scores(ids: Collection<String>): List<WvwMatchScore> = chunkedIds(ids, "${WVW}/${MATCHES}/${SCORES}", instance = { WvwMatchScore(id = it) })

    /**
     * @return all the match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scores(): List<WvwMatchScore> = allIds("${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return the ids of the available match stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun statIds(): List<String> = getList(path = "${WVW}/${MATCHES}/${STATS}")

    /**
     * @return the match stat associated with the [worldId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stat(worldId: Int): WvwMatchStat = getSingleByWorld(worldId, "${WVW}/${MATCHES}/${STATS}", instance = { WvwMatchStat() })

    /**
     * @return the match stat associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stat(id: String): WvwMatchStat = getSingleById(id, "${WVW}/${MATCHES}/${STATS}", instance = { WvwMatchStat(id = it) })

    /**
     * @return the match stats associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stats(ids: Collection<String>): List<WvwMatchStat> = chunkedIds(ids, "${WVW}/${MATCHES}/${STATS}", instance = { WvwMatchStat(id = it) })

    /**
     * @return all the match stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stats(): List<WvwMatchStat> = allIds("${WVW}/${MATCHES}/${STATS}")

    /**
     * @return the ids of the available objectives
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    suspend fun objectiveIds(): List<String> = getList(path = "${WVW}/${OBJECTIVES}")

    /**
     * @return the objective associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    suspend fun objective(id: String, language: String? = null): WvwObjective = getSingleById(id, "${WVW}/${OBJECTIVES}", instance = { WvwObjective(id = it) }) {
        language(language)
    }

    /**
     * @return the objectives associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    suspend fun objectives(ids: Collection<String>, language: String? = null): List<WvwObjective> =
        chunkedIds(ids, "${WVW}/${OBJECTIVES}", instance = { WvwObjective(id = it) }) {
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
    suspend fun rankIds(): List<Int> = getList(path = "${WVW}/${RANKS}")

    /**
     * @return the rank associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">the wiki</a>
     */
    suspend fun rank(id: Int, language: String? = null): WvwRank = getSingleById(id, "${WVW}/${RANKS}", instance = { WvwRank(id = it) }) {
        language(language)
    }

    /**
     * @return the ranks associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">the wiki</a>
     */
    suspend fun ranks(ids: Collection<Int>, language: String? = null): List<WvwRank> = chunkedIds(ids, "${WVW}/${RANKS}", instance = { WvwRank(id = it) }) {
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
    suspend fun upgradeIds(): List<Int> = getList(path = "${WVW}/${UPGRADES}")

    /**
     * @return the upgrade associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">the wiki</a>
     */
    suspend fun upgrade(id: Int, language: String? = null): WvwUpgrade = getSingleById(id, "${WVW}/${UPGRADES}", instance = { WvwUpgrade(id = it) }) {
        language(language)
    }

    /**
     * @return the upgrades associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">the wiki</a>
     */
    suspend fun upgrades(ids: Collection<Int>, language: String? = null): List<WvwUpgrade> = chunkedIds(ids, "${WVW}/${UPGRADES}", instance = { WvwUpgrade(id = it) }) {
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