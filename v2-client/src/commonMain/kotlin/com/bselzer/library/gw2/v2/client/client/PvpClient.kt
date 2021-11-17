package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.client.extension.bearer
import com.bselzer.library.gw2.v2.client.extension.language
import com.bselzer.library.gw2.v2.model.pvp.PvpAmulet
import com.bselzer.library.gw2.v2.model.pvp.PvpGame
import com.bselzer.library.gw2.v2.model.pvp.hero.PvpHero
import com.bselzer.library.gw2.v2.model.pvp.leaderboard.PvpLeaderboard
import com.bselzer.library.gw2.v2.model.pvp.rank.PvpRank
import com.bselzer.library.gw2.v2.model.pvp.season.PvpSeason
import com.bselzer.library.gw2.v2.model.pvp.standing.PvpStandings
import com.bselzer.library.gw2.v2.model.pvp.stat.PvpStats
import com.bselzer.library.gw2.v2.scope.core.Permission
import com.bselzer.library.gw2.v2.scope.core.Requirement
import com.bselzer.library.gw2.v2.scope.core.Scope
import io.ktor.client.*

/**
 * The player vs. player client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp">the wiki</a>
 */
@Scope(Requirement.OPTIONAL, Permission.ACCOUNT, Permission.PVP)
class PvpClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
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
    suspend fun stats(token: String? = null): PvpStats = getSingle(path = "${PVP}/${STATS}") {
        bearer(token)
    }

    /**
     * @return the ids of the most recently played games. Limited to at most 10 games.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun gameIds(token: String? = null): List<String> = getList(path = "${PVP}/${GAMES}") {
        bearer(token)
    }

    /**
     * @return the game associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun game(id: String, token: String? = null): PvpGame = getSingleById(id, "${PVP}/${GAMES}") {
        bearer(token)
    }

    /**
     * @return the games associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun games(ids: Collection<String>, token: String? = null): List<PvpGame> = chunkedIds(ids, "${PVP}/${GAMES}") {
        bearer(token)
    }

    /**
     * @return the most recently played games. Limited to at most 10 games.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun games(token: String? = null): List<PvpGame> = allIds("${PVP}/${GAMES}") {
        bearer(token)
    }

    /**
     * @return the pip and division standings
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/standings">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun standings(token: String? = null): PvpStandings = getSingle(path = "${PVP}/${STANDINGS}") {
        bearer(token)
    }

    /**
     * @return the ids of the available ranks
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    suspend fun rankIds(): List<Int> = getList(path = "${PVP}/${RANKS}")

    /**
     * @return the rank associated with the [id]
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    suspend fun rank(id: Int, language: String? = null): PvpRank = getSingleById(id, "${PVP}/${RANKS}") {
        language(language)
    }

    /**
     * @return the ranks associated with the [ids]
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    suspend fun ranks(ids: Collection<Int>, language: String? = null): List<PvpRank> = chunkedIds(ids, "${PVP}/${RANKS}") {
        language(language)
    }

    /**
     * @return all the ranks
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    suspend fun ranks(language: String? = null): List<PvpRank> = allIds("${PVP}/${RANKS}") {
        language(language)
    }

    /**
     * @return the ids of all the PvP League seasons
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    suspend fun seasonsIds(): List<String> = getList(path = "${PVP}/${SEASONS}")

    /**
     * @return the season associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    suspend fun season(id: String, language: String? = null): PvpSeason = getSingleById(id, "${PVP}/${SEASONS}") {
        language(language)
    }

    /**
     * @return the seasons associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    suspend fun seasons(ids: Collection<String>, language: String? = null): List<PvpSeason> = chunkedIds(ids, "${PVP}/${SEASONS}") {
        language(language)
    }

    /**
     * @return all the seasons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    suspend fun seasons(language: String? = null): List<PvpSeason> = allIds("${PVP}/${SEASONS}") {
        language(language)
    }

    /**
     * @return the available regions with leaderboards
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons/:id/leaderboards>the wiki</a>
     */
    // TODO enum and extension method
    suspend fun leaderboardRegions(seasonId: String): List<PvpLeaderboard> = getList(path = "${PVP}/${SEASONS}/${seasonId}/${LEADERBOARDS}")

    /**
     * @return the leaderboards for the [region] during the season with [seasonId]
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/seasons/:id/leaderboards">the wiki</a>
     * @since season 5
     */
    suspend fun leaderboards(seasonId: String, region: String, language: String? = null): List<PvpLeaderboard> =
        getList(path = "${PVP}/${SEASONS}/${seasonId}/${LEADERBOARDS}/${LADDER}/${region}") {
            language(language)
        }

    /**
     * @return the ids of the heroes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">the wiki</a>
     */
    suspend fun heroIds(): List<String> = getList(path = "${PVP}/${HEROES}")

    /**
     * @return the hero associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">the wiki</a>
     */
    suspend fun hero(id: String, language: String? = null): PvpHero = getSingleById(id, "${PVP}/${HEROES}") {
        language(language)
    }

    /**
     * @return the heroes associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">the wiki</a>
     */
    suspend fun heroes(ids: Collection<String>, language: String? = null): List<PvpHero> = chunkedIds(ids, "${PVP}/${HEROES}") {
        language(language)
    }

    /**
     * @return all the heroes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">the wiki</a>
     */
    suspend fun heroes(language: String? = null): List<PvpHero> = allIds("${PVP}/${HEROES}") {
        language(language)
    }

    /**
     * @return the ids of the amulets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    suspend fun amuletIds(): List<Int> = getList(path = "${PVP}/${AMULETS}")

    /**
     * @return the amulet associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    suspend fun amulet(id: Int, language: String? = null): PvpAmulet = getSingleById(id, "${PVP}/${AMULETS}") {
        language(language)
    }

    /**
     * @return the amulets associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    suspend fun amulets(ids: Collection<Int>, language: String? = null): List<PvpAmulet> = chunkedIds(ids, "${PVP}/${AMULETS}") {
        language(language)
    }

    /**
     * @return all the amulets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    suspend fun amulets(language: String? = null): List<PvpAmulet> = allIds("${PVP}/${AMULETS}") {
        language(language)
    }
}