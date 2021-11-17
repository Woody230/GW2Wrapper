package com.bselzer.library.gw2.v2.client.client

import com.bselzer.library.gw2.v2.client.extension.language
import com.bselzer.library.gw2.v2.model.achievement.Achievement
import com.bselzer.library.gw2.v2.model.achievement.AchievementCategory
import com.bselzer.library.gw2.v2.model.achievement.AchievementGroup
import com.bselzer.library.gw2.v2.model.achievement.daily.Dailies
import io.ktor.client.*

/**
 * The achievement client.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
 */
class AchievementClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    private companion object
    {
        const val ACHIEVEMENTS = "achievements"
        const val DAILY = "daily"
        const val TOMORROW = "tomorrow"
        const val GROUPS = "groups"
        const val CATEGORIES = "categories"
    }

    /**
     * @return the ids of all achievements
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    suspend fun ids(): List<Int> = getList(path = ACHIEVEMENTS)

    /**
     * @return the achievement associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    suspend fun achievement(id: Int, language: String? = null): Achievement = getSingleById(id, ACHIEVEMENTS) {
        language(language)
    }

    /**
     * @return the achievements associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    suspend fun achievements(ids: Collection<Int>, language: String? = null): List<Achievement> = chunkedIds(ids, ACHIEVEMENTS) {
        language(language)
    }

    /**
     * @return today's dailies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/daily">the wiki</a>
     */
    suspend fun dailiesForToday(): Dailies = getSingle(path = "${ACHIEVEMENTS}/${DAILY}")

    /**
     * @return tomorrow's dailies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/daily/tomorrow">the wiki</a>
     */
    suspend fun dailiesForTomorrow(): Dailies = getSingle(path = "${ACHIEVEMENTS}/${DAILY}/${TOMORROW}")

    /**
     * @return the ids of all achievement groups
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">the wiki</a>
     */
    suspend fun groupIds(): List<String> = getList(path = "${ACHIEVEMENTS}/${GROUPS}")

    /**
     * @return the achievement group associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">the wiki</a>
     */
    suspend fun group(id: String, language: String? = null): AchievementGroup = getSingleById(id, "${ACHIEVEMENTS}/${GROUPS}") {
        language(language)
    }

    /**
     * @return the achievement groups associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">the wiki</a>
     */
    suspend fun groups(ids: Collection<String>, language: String? = null): List<AchievementGroup> = chunkedIds(ids, "${ACHIEVEMENTS}/${GROUPS}") {
        language(language)
    }

    /**
     * @return all the achievement groups
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">the wiki</a>
     */
    suspend fun groups(language: String? = null): List<AchievementGroup> = allIds("${ACHIEVEMENTS}/${GROUPS}") {
        language(language)
    }

    /**
     * @return the ids of all achievement categories
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">the wiki</a>
     */
    suspend fun categoryIds(): List<Int> = getList(path = "${ACHIEVEMENTS}/${CATEGORIES}")

    /**
     * @return the achievement category associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">the wiki</a>
     */
    suspend fun category(id: Int, language: String? = null): AchievementCategory =
        getSingleById(id, "${ACHIEVEMENTS}/${CATEGORIES}") {
            language(language)
        }

    /**
     * @return the achievement categories associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">the wiki</a>
     */
    suspend fun categories(ids: Collection<Int>, language: String? = null): List<AchievementCategory> =
        chunkedIds(ids, "${ACHIEVEMENTS}/${CATEGORIES}") {
            language(language)
        }

    /**
     * @return all the achievement categories
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">the wiki</a>
     */
    suspend fun categories(language: String? = null): List<AchievementCategory> =
        allIds("${ACHIEVEMENTS}/${CATEGORIES}") {
            language(language)
        }
}