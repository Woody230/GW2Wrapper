package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import com.bselzer.library.gw2.v2.client.common.constant.endpoint.PvP
import com.bselzer.library.gw2.v2.client.common.extension.ensureBearer
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.pvp.PvpAmulet
import com.bselzer.library.gw2.v2.model.common.pvp.PvpGame
import com.bselzer.library.gw2.v2.model.common.pvp.leaderboard.PvpLeaderboard
import com.bselzer.library.gw2.v2.model.common.pvp.rank.PvpRank
import com.bselzer.library.gw2.v2.model.common.pvp.season.PvpSeason
import com.bselzer.library.gw2.v2.model.common.pvp.standing.PvpStandings
import com.bselzer.library.gw2.v2.model.common.pvp.stat.PvpStats
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The player vs. player client.
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp">the wiki</a>
 */
@Scope(Requirement.OPTIONAL, Permission.ACCOUNT, Permission.PVP)
class PvpClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return an account's PvP stats
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/stats">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun stats(token: String? = null): PvpStats = httpClient.get(path = "${PvP.PVP}/${PvP.STATS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the most recently played games. Limited to at most 10 games.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun gameIds(token: String? = null): List<String> = httpClient.get(path = "${PvP.PVP}/${PvP.GAMES}") {
        ensureBearer(token)
    }

    /**
     * @return the game associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun game(id: String, token: String? = null): PvpGame = single(id, "${PvP.PVP}/${PvP.GAMES}") {
        ensureBearer(token)
    }

    /**
     * @return the games associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun games(ids: Collection<String>, token: String? = null): List<PvpGame> = chunkedIds(ids, "${PvP.PVP}/${PvP.GAMES}") {
        ensureBearer(token)
    }

    /**
     * @return the most recently played games. Limited to at most 10 games.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/games">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun games(token: String? = null): List<PvpGame> = allIds("${PvP.PVP}/${PvP.GAMES}") {
        ensureBearer(token)
    }

    /**
     * @return the pip and division standings
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/standings">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PVP)
    suspend fun standings(token: String? = null): PvpStandings = httpClient.get(path = "${PvP.PVP}/${PvP.STANDINGS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the available ranks
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    suspend fun rankIds(): List<Int> = httpClient.get(path = "${PvP.PVP}/${PvP.RANKS}")

    /**
     * @return the rank associated with the [id]
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    suspend fun rank(id: Int, language: String? = null): PvpRank = single(id, "${PvP.PVP}/${PvP.RANKS}") {
        language(language)
    }

    /**
     * @return the ranks associated with the [ids]
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    suspend fun ranks(ids: Collection<Int>, language: String? = null): List<PvpRank> = chunkedIds(ids, "${PvP.PVP}/${PvP.RANKS}") {
        language(language)
    }

    /**
     * @return all the ranks
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/ranks">the wiki</a>
     */
    suspend fun ranks(language: String? = null): List<PvpRank> = allIds("${PvP.PVP}/${PvP.RANKS}") {
        language(language)
    }

    /**
     * @return the ids of all the PvP League seasons
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    suspend fun seasonsIds(): List<String> = httpClient.get(path = "${PvP.PVP}/${PvP.SEASONS}")

    /**
     * @return the season associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    suspend fun season(id: String, language: String? = null): PvpSeason = single(id, "${PvP.PVP}/${PvP.SEASONS}") {
        language(language)
    }

    /**
     * @return the seasons associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    suspend fun seasons(ids: Collection<String>, language: String? = null): List<PvpSeason> = chunkedIds(ids, "${PvP.PVP}/${PvP.SEASONS}") {
        language(language)
    }

    /**
     * @return all the seasons
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    suspend fun seasons(language: String? = null): List<PvpSeason> = allIds("${PvP.PVP}/${PvP.SEASONS}") {
        language(language)
    }

    /**
     * @return the available regions with leaderboards
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons/:id/leaderboards>the wiki</a>
     */
    // TODO enum and extension method
    suspend fun leaderboardRegions(seasonId: String): List<PvpLeaderboard> = httpClient.get(path = "${PvP.PVP}/${PvP.SEASONS}/${seasonId}/${PvP.LEADERBOARDS}")

    /**
     * @return the leaderboards for the [region] during the season with [seasonId]
     * @see <a href='https://wiki.guildwars2.com/wiki/API:2/pvp/seasons/:id/leaderboards">the wiki</a>
     * @since season 5
     */
    suspend fun leaderboards(seasonId: String, region: String, language: String? = null): List<PvpLeaderboard> =
        httpClient.get(path = "${PvP.PVP}/${PvP.SEASONS}/${seasonId}/${PvP.LEADERBOARDS}/${PvP.LADDER}/${region}") {
            language(language)
        }

    /**
     * @return the ids of the heroes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">the wiki</a>
     */
    suspend fun heroIds(): List<String> = httpClient.get(path = "${PvP.PVP}/${PvP.HEROES}")

    /**
     * @return the hero associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">the wiki</a>
     */
    suspend fun hero(id: String, language: String? = null): String = single(id, "${PvP.PVP}/${PvP.HEROES}") {
        language(language)
    }

    /**
     * @return the heroes associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">the wiki</a>
     */
    suspend fun heroes(ids: Collection<String>, language: String? = null): List<String> = chunkedIds(ids, "${PvP.PVP}/${PvP.HEROES}") {
        language(language)
    }

    /**
     * @return all the heroes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/heroes">the wiki</a>
     */
    suspend fun heroes(language: String? = null): List<String> = allIds("${PvP.PVP}/${PvP.HEROES}") {
        language(language)
    }

    /**
     * @return the ids of the amulets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    suspend fun amuletIds(): List<Int> = httpClient.get(path = "${PvP.PVP}/${PvP.AMULETS}")

    /**
     * @return the amulet associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    suspend fun amulet(id: Int, language: String? = null): PvpAmulet = single(id, "${PvP.PVP}/${PvP.AMULETS}") {
        language(language)
    }

    /**
     * @return the amulets associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    suspend fun amulets(ids: Collection<Int>, language: String? = null): List<PvpAmulet> = chunkedIds(ids, "${PvP.PVP}/${PvP.AMULETS}") {
        language(language)
    }

    /**
     * @return all the amulets
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/amulets">the wiki</a>
     */
    suspend fun amulets(language: String? = null): List<PvpAmulet> = allIds("${PvP.PVP}/${PvP.AMULETS}") {
        language(language)
    }
}