package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.world.WorldId
import com.bselzer.gw2.v2.model.wvw.ability.WvwAbility
import com.bselzer.gw2.v2.model.wvw.ability.WvwAbilityId
import com.bselzer.gw2.v2.model.wvw.match.*
import com.bselzer.gw2.v2.model.wvw.objective.WvwMapObjectiveId
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.gw2.v2.model.wvw.rank.WvwRank
import com.bselzer.gw2.v2.model.wvw.rank.WvwRankId
import com.bselzer.gw2.v2.model.wvw.upgrade.WvwUpgrade
import com.bselzer.gw2.v2.model.wvw.upgrade.WvwUpgradeId
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The world vs. world client.
 * @see <a href='https://wiki.guildwars2.com/wiki/API:2/wvw">the wiki</a>
 */
class WvwClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
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
    private fun HttpRequestBuilder.world(world: WorldId) = parameter("world", world.value)

    /**
     * @return a single object
     */
    private suspend inline fun <reified T> getSingleByWorld(worldId: WorldId, basePath: String, instance: () -> T, block: HttpRequestBuilder.() -> Unit = {}): T =
        getSingle(path = basePath, instance = instance) {
            world(worldId)
            apply(block)
        }

    /**
     * @return the ids of the available abilities
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilityIds(): List<WvwAbilityId> = getIds(path = "${WVW}/${ABILITIES}")

    /**
     * @return the ability associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun ability(id: WvwAbilityId, language: Language? = null): WvwAbility = getSingleById(id, "${WVW}/${ABILITIES}", instance = { WvwAbility(id = it) }) {
        language(language)
    }

    /**
     * @return the abilities associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilities(ids: Collection<WvwAbilityId>, language: Language? = null): List<WvwAbility> =
        chunkedIds(ids, "${WVW}/${ABILITIES}", instance = { WvwAbility(id = it) }) {
            language(language)
        }

    /**
     * @return all the abilities
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/abilities">the wiki</a>
     */
    suspend fun abilities(language: Language? = null): List<WvwAbility> = allIds("${WVW}/${ABILITIES}") {
        language(language)
    }

    /**
     * @return the ids of the available matches
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matchIds(): List<WvwMatchId> = getIds(path = "${WVW}/${MATCHES}")

    /**
     * @return the match associated with the [worldId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun match(worldId: WorldId): WvwMatch = getSingleByWorld(worldId, "${WVW}/${MATCHES}", instance = { WvwMatch() })

    /**
     * @return the match associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun match(id: WvwMatchId): WvwMatch = getSingleById(id, "${WVW}/${MATCHES}", instance = { WvwMatch(id = it) })

    /**
     * @return the matches associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matches(ids: Collection<WvwMatchId>): List<WvwMatch> = chunkedIds(ids, "${WVW}/${MATCHES}", instance = { WvwMatch(id = it) })

    /**
     * @return all the matches
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun matches(): List<WvwMatch> = allIds("${WVW}/${MATCHES}")

    /**
     * @return the ids of the available match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviewIds(): List<WvwMatchId> = getIds(path = "${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return the match overview associated with the [worldId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overview(worldId: WorldId): WvwMatchOverview = getSingleByWorld(worldId, "${WVW}/${MATCHES}/${OVERVIEW}", instance = { WvwMatchOverview() })

    /**
     * @return the match overview associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overview(id: WvwMatchId): WvwMatchOverview = getSingleById(id, "${WVW}/${MATCHES}/${OVERVIEW}", instance = { WvwMatchOverview(id = it) })

    /**
     * @return the match overviews associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviews(ids: Collection<WvwMatchId>): List<WvwMatchOverview> = chunkedIds(ids, "${WVW}/${MATCHES}/${OVERVIEW}", instance = { WvwMatchOverview(id = it) })

    /**
     * @return all the match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun overviews(): List<WvwMatchOverview> = allIds("${WVW}/${MATCHES}/${OVERVIEW}")

    /**
     * @return the ids of the available match scores
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scoreIds(): List<WvwMatchId> = getIds(path = "${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return the match score associated with the [worldId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun score(worldId: WorldId): WvwMatchScore = getSingleByWorld(worldId, "${WVW}/${MATCHES}/${SCORES}", instance = { WvwMatchScore() })

    /**
     * @return the match score associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun score(id: WvwMatchId): WvwMatchScore = getSingleById(id, "${WVW}/${MATCHES}/${SCORES}", instance = { WvwMatchScore(id = it) })

    /**
     * @return the match scores associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scores(ids: Collection<WvwMatchId>): List<WvwMatchScore> = chunkedIds(ids, "${WVW}/${MATCHES}/${SCORES}", instance = { WvwMatchScore(id = it) })

    /**
     * @return all the match overviews
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun scores(): List<WvwMatchScore> = allIds("${WVW}/${MATCHES}/${SCORES}")

    /**
     * @return the ids of the available match stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun statIds(): List<WvwMatchId> = getIds(path = "${WVW}/${MATCHES}/${STATS}")

    /**
     * @return the match stat associated with the [worldId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stat(worldId: WorldId): WvwMatchStat = getSingleByWorld(worldId, "${WVW}/${MATCHES}/${STATS}", instance = { WvwMatchStat() })

    /**
     * @return the match stat associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stat(id: WvwMatchId): WvwMatchStat = getSingleById(id, "${WVW}/${MATCHES}/${STATS}", instance = { WvwMatchStat(id = it) })

    /**
     * @return the match stats associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stats(ids: Collection<WvwMatchId>): List<WvwMatchStat> = chunkedIds(ids, "${WVW}/${MATCHES}/${STATS}", instance = { WvwMatchStat(id = it) })

    /**
     * @return all the match stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/matches">the wiki</a>
     */
    suspend fun stats(): List<WvwMatchStat> = allIds("${WVW}/${MATCHES}/${STATS}")

    /**
     * @return the ids of the available objectives
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    suspend fun objectiveIds(): List<WvwMapObjectiveId> = getIds(path = "${WVW}/${OBJECTIVES}")

    /**
     * @return the objective associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    suspend fun objective(id: WvwMapObjectiveId, language: Language? = null): WvwObjective = getSingleById(id, "${WVW}/${OBJECTIVES}", instance = { WvwObjective(id = it) }) {
        language(language)
    }

    /**
     * @return the objectives associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    suspend fun objectives(ids: Collection<WvwMapObjectiveId>, language: Language? = null): List<WvwObjective> =
        chunkedIds(ids, "${WVW}/${OBJECTIVES}", instance = { WvwObjective(id = it) }) {
            language(language)
        }

    /**
     * @return all the objectives
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/objectives">the wiki</a>
     */
    suspend fun objectives(language: Language? = null): List<WvwObjective> = allIds("${WVW}/${OBJECTIVES}") {
        language(language)
    }

    /**
     * @return the ids of the available ranks
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">the wiki</a>
     */
    suspend fun rankIds(): List<WvwRankId> = getIds(path = "${WVW}/${RANKS}")

    /**
     * @return the rank associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">the wiki</a>
     */
    suspend fun rank(id: WvwRankId, language: Language? = null): WvwRank = getSingleById(id, "${WVW}/${RANKS}", instance = { WvwRank(id = it) }) {
        language(language)
    }

    /**
     * @return the ranks associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">the wiki</a>
     */
    suspend fun ranks(ids: Collection<WvwRankId>, language: Language? = null): List<WvwRank> = chunkedIds(ids, "${WVW}/${RANKS}", instance = { WvwRank(id = it) }) {
        language(language)
    }

    /**
     * @return all the ranks
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/ranks">the wiki</a>
     */
    suspend fun ranks(language: Language? = null): List<WvwRank> = allIds("${WVW}/${RANKS}") {
        language(language)
    }

    /**
     * @return the ids of the available upgrades
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">the wiki</a>
     */
    suspend fun upgradeIds(): List<WvwUpgradeId> = getIds(path = "${WVW}/${UPGRADES}")

    /**
     * @return the upgrade associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">the wiki</a>
     */
    suspend fun upgrade(id: WvwUpgradeId, language: Language? = null): WvwUpgrade = getSingleById(id, "${WVW}/${UPGRADES}", instance = { WvwUpgrade(id = it) }) {
        language(language)
    }

    /**
     * @return the upgrades associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">the wiki</a>
     */
    suspend fun upgrades(ids: Collection<WvwUpgradeId>, language: Language? = null): List<WvwUpgrade> =
        chunkedIds(ids, "${WVW}/${UPGRADES}", instance = { WvwUpgrade(id = it) }) {
            language(language)
        }

    /**
     * @return all the upgrades
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">the wiki</a>
     */
    suspend fun upgrades(language: Language? = null): List<WvwUpgrade> = allIds("${WVW}/${UPGRADES}") {
        language(language)
    }
}