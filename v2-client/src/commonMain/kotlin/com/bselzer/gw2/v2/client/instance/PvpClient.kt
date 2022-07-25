package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.bearer
import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.model.pvp.amulet.PvpAmulet
import com.bselzer.gw2.v2.model.pvp.amulet.PvpAmuletId
import com.bselzer.gw2.v2.model.pvp.game.PvpGame
import com.bselzer.gw2.v2.model.pvp.game.PvpGameId
import com.bselzer.gw2.v2.model.pvp.hero.PvpHero
import com.bselzer.gw2.v2.model.pvp.hero.PvpHeroId
import com.bselzer.gw2.v2.model.pvp.leaderboard.PvpLeaderboard
import com.bselzer.gw2.v2.model.pvp.rank.PvpRank
import com.bselzer.gw2.v2.model.pvp.rank.PvpRankId
import com.bselzer.gw2.v2.model.pvp.season.PvpSeason
import com.bselzer.gw2.v2.model.pvp.season.PvpSeasonId
import com.bselzer.gw2.v2.model.pvp.standing.PvpStandings
import com.bselzer.gw2.v2.model.pvp.stat.PvpStats
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import io.ktor.client.*

/**
 * The player vs. player client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp">the wiki</a>
 */
@Scope(Requirement.OPTIONAL, Permission.ACCOUNT, Permission.PVP)
class PvpClient(httpClient: HttpClient, configuration: DefaultGw2HttpOptions) : BaseClient(httpClient, configuration) {
    private companion object {
        const val PVP = "pvp"
        const val STATS = "stats"
        const val GAMES = "games"
        const val STANDINGS = "standings"
        const val RANKS = "ranks"
        const val SEASONS = "seasons"
        const val LEADERBOARDS = "leaderboards"
        const val LADDER = "ladder"
        const val HEROES = "heroes"
        const val AMULETS = "amulets"
    }

    /**
     * @return an account's PvP stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/stats">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun stats(token: Token? = null): PvpStats = getSingle(path = "${PVP}/${STATS}", instance = { PvpStats() }) {
        bearer(token)
    }

    /**
     * @return the ids of the most recently played games. Limited to at most 10 games.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun gameIds(token: Token? = null): List<PvpGameId> = getList(path = "${PVP}/${GAMES}") {
        bearer(token)
    }

    /**
     * @return the game associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun game(id: PvpGameId, token: Token? = null): PvpGame = getSingleById(id, "${PVP}/${GAMES}", instance = { PvpGame(id = it) }) {
        bearer(token)
    }

    /**
     * @return the games associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun games(ids: Collection<PvpGameId>, token: Token? = null): List<PvpGame> = chunkedIds(ids, "${PVP}/${GAMES}", instance = { PvpGame(id = it) }) {
        bearer(token)
    }

    /**
     * @return the most recently played games. Limited to at most 10 games.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun games(token: Token? = null): List<PvpGame> = allIds("${PVP}/${GAMES}") {
        bearer(token)
    }

    /**
     * @return the pip and division standings
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/standings">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun standings(token: Token? = null): PvpStandings = getSingle(path = "${PVP}/${STANDINGS}", instance = { PvpStandings() }) {
        bearer(token)
    }

    /**
     * @return the ids of the available ranks
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    suspend fun rankIds(): List<PvpRankId> = getIds(path = "${PVP}/${RANKS}")

    /**
     * @return the rank associated with the [id]
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    suspend fun rank(id: PvpRankId, language: Language? = null): PvpRank = getSingleById(id, "${PVP}/${RANKS}", instance = { PvpRank(id = it) }) {
        language(language)
    }

    /**
     * @return the ranks associated with the [ids]
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    suspend fun ranks(ids: Collection<PvpRankId>, language: Language? = null): List<PvpRank> = chunkedIds(ids, "${PVP}/${RANKS}", instance = { PvpRank(id = it) }) {
        language(language)
    }

    /**
     * @return all the ranks
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    suspend fun ranks(language: Language? = null): List<PvpRank> = allIds("${PVP}/${RANKS}") {
        language(language)
    }

    /**
     * @return the ids of all the PvP League seasons
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    suspend fun seasonsIds(): List<PvpSeasonId> = getIds(path = "${PVP}/${SEASONS}")

    /**
     * @return the season associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    suspend fun season(id: PvpSeasonId, language: Language? = null): PvpSeason = getSingleById(id, "${PVP}/${SEASONS}", instance = { PvpSeason(id = it) }) {
        language(language)
    }

    /**
     * @return the seasons associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    suspend fun seasons(ids: Collection<PvpSeasonId>, language: Language? = null): List<PvpSeason> = chunkedIds(ids, "${PVP}/${SEASONS}", instance = { PvpSeason(id = it) }) {
        language(language)
    }

    /**
     * @return all the seasons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    suspend fun seasons(language: Language? = null): List<PvpSeason> = allIds("${PVP}/${SEASONS}") {
        language(language)
    }

    /**
     * @return the available regions with leaderboards
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons/:id/leaderboards>the wiki</a>
     */
    suspend fun leaderboardRegions(seasonId: PvpSeasonId): List<PvpLeaderboard> = getList(path = "${PVP}/${SEASONS}/${seasonId}/${LEADERBOARDS}")

    /**
     * @return the leaderboards for the [region] during the season with [seasonId]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons/:id/leaderboards">the wiki</a>
     * @since season 5
     */
    suspend fun leaderboards(seasonId: PvpSeasonId, region: String, language: Language? = null): List<PvpLeaderboard> =
        getList(path = "${PVP}/${SEASONS}/${seasonId}/${LEADERBOARDS}/${LADDER}/${region}") {
            language(language)
        }

    /**
     * @return the ids of the heroes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">the wiki</a>
     */
    suspend fun heroIds(): List<PvpHeroId> = getIds(path = "${PVP}/${HEROES}")

    /**
     * @return the hero associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">the wiki</a>
     */
    suspend fun hero(id: PvpHeroId, language: Language? = null): PvpHero = getSingleById(id, "${PVP}/${HEROES}", instance = { PvpHero(id = it) }) {
        language(language)
    }

    /**
     * @return the heroes associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">the wiki</a>
     */
    suspend fun heroes(ids: Collection<PvpHeroId>, language: Language? = null): List<PvpHero> = chunkedIds(ids, "${PVP}/${HEROES}", instance = { PvpHero(id = it) }) {
        language(language)
    }

    /**
     * @return all the heroes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">the wiki</a>
     */
    suspend fun heroes(language: Language? = null): List<PvpHero> = allIds("${PVP}/${HEROES}") {
        language(language)
    }

    /**
     * @return the ids of the amulets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    suspend fun amuletIds(): List<PvpAmuletId> = getIds(path = "${PVP}/${AMULETS}")

    /**
     * @return the amulet associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    suspend fun amulet(id: PvpAmuletId, language: Language? = null): PvpAmulet = getSingleById(id, "${PVP}/${AMULETS}", instance = { PvpAmulet(id = it) }) {
        language(language)
    }

    /**
     * @return the amulets associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    suspend fun amulets(ids: Collection<PvpAmuletId>, language: Language? = null): List<PvpAmulet> = chunkedIds(ids, "${PVP}/${AMULETS}", instance = { PvpAmulet(id = it) }) {
        language(language)
    }

    /**
     * @return all the amulets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    suspend fun amulets(language: Language? = null): List<PvpAmulet> = allIds("${PVP}/${AMULETS}") {
        language(language)
    }
}