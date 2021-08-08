package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Achievements
import com.bselzer.library.gw2.v2.client.common.extension.language
import com.bselzer.library.gw2.v2.model.common.achievement.Achievement
import com.bselzer.library.gw2.v2.model.common.achievement.AchievementCategory
import com.bselzer.library.gw2.v2.model.common.achievement.AchievementGroup
import com.bselzer.library.gw2.v2.model.common.achievement.daily.Dailies
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * The achievement client.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
 */
class AchievementClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the ids of all achievements
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    suspend fun ids(): List<Int> = httpClient.get(path = Achievements.ACHIEVEMENTS)

    /**
     * @return the achievements associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    suspend fun achievements(ids: Collection<Int>, language: String? = null): List<Achievement> = chunkedIds(ids, Achievements.ACHIEVEMENTS) {
        language(language)
    }

    /**
     * @return today's dailies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/daily">the wiki</a>
     */
    suspend fun dailiesForToday(): Dailies = httpClient.get(path = "${Achievements.ACHIEVEMENTS}/${Achievements.DAILY}")

    /**
     * @return tomorrow's dailies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/daily/tomorrow">the wiki</a>
     */
    suspend fun dailiesForTomorrow(): Dailies = httpClient.get(path = "${Achievements.ACHIEVEMENTS}/${Achievements.DAILY}/${Achievements.TOMORROW}")

    /**
     * @return the ids of all achievement groups
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">the wiki</a>
     */
    suspend fun groupIds(): List<String> = httpClient.get(path = "${Achievements.ACHIEVEMENTS}/${Achievements.GROUPS}")

    /**
     * @return the achievement groups associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">the wiki</a>
     */
    suspend fun groups(ids: Collection<String>, language: String? = null): List<AchievementGroup> = chunkedIds(ids, "${Achievements.ACHIEVEMENTS}/${Achievements.GROUPS}") {
        language(language)
    }

    /**
     * @return all the achievement groups
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">the wiki</a>
     */
    suspend fun groups(language: String? = null): List<AchievementGroup> = allIds("${Achievements.ACHIEVEMENTS}/${Achievements.GROUPS}") {
        language(language)
    }

    /**
     * @return the ids of all achievement categories
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">the wiki</a>
     */
    suspend fun categoryIds(): List<Int> = httpClient.get(path = "${Achievements.ACHIEVEMENTS}/${Achievements.CATEGORIES}")

    /**
     * @return the achievement categories associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">the wiki</a>
     */
    suspend fun categories(ids: Collection<Int>, language: String? = null): List<AchievementCategory> =
        chunkedIds(ids, "${Achievements.ACHIEVEMENTS}/${Achievements.CATEGORIES}") {
            language(language)
        }

    /**
     * @return all the achievement categories
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">the wiki</a>
     */
    suspend fun categories(language: String? = null): List<AchievementCategory> =
        allIds("${Achievements.ACHIEVEMENTS}/${Achievements.CATEGORIES}") {
            language(language)
        }
}