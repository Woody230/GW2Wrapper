package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.extension.language
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.model.achievement.Achievement
import com.bselzer.gw2.v2.model.achievement.AchievementId
import com.bselzer.gw2.v2.model.achievement.category.AchievementCategory
import com.bselzer.gw2.v2.model.achievement.category.AchievementCategoryId
import com.bselzer.gw2.v2.model.achievement.daily.Dailies
import com.bselzer.gw2.v2.model.achievement.group.AchievementGroup
import com.bselzer.gw2.v2.model.achievement.group.AchievementGroupId
import io.ktor.client.*

/**
 * The achievement client.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
 */
class AchievementClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
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
    suspend fun ids(): List<AchievementId> = getIds(path = ACHIEVEMENTS)

    /**
     * @return the achievement associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    suspend fun achievement(id: AchievementId, language: Language? = null): Achievement = getSingleById(id, ACHIEVEMENTS, instance = { Achievement(id = it) }) {
        language(language)
    }

    /**
     * @return the achievements associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    suspend fun achievements(ids: Collection<AchievementId>, language: Language? = null): List<Achievement> =
        chunkedIds(ids, ACHIEVEMENTS, instance = { Achievement(id = it) }) {
            language(language)
        }

    /**
     * @return today's dailies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/daily">the wiki</a>
     */
    suspend fun dailiesForToday(): Dailies = getSingle(path = "${ACHIEVEMENTS}/${DAILY}", instance = { Dailies() })

    /**
     * @return tomorrow's dailies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/daily/tomorrow">the wiki</a>
     */
    suspend fun dailiesForTomorrow(): Dailies = getSingle(path = "${ACHIEVEMENTS}/${DAILY}/${TOMORROW}", instance = { Dailies() })

    /**
     * @return the ids of all achievement groups
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">the wiki</a>
     */
    suspend fun groupIds(): List<AchievementGroupId> = getIds(path = "${ACHIEVEMENTS}/${GROUPS}")

    /**
     * @return the achievement group associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">the wiki</a>
     */
    suspend fun group(id: AchievementGroupId, language: Language? = null): AchievementGroup =
        getSingleById(id, "${ACHIEVEMENTS}/${GROUPS}", instance = { AchievementGroup(id = it) }) {
            language(language)
        }

    /**
     * @return the achievement groups associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">the wiki</a>
     */
    suspend fun groups(ids: Collection<AchievementGroupId>, language: Language? = null): List<AchievementGroup> =
        chunkedIds(ids, "${ACHIEVEMENTS}/${GROUPS}", instance = { AchievementGroup(id = it) }) {
            language(language)
        }

    /**
     * @return all the achievement groups
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/groups">the wiki</a>
     */
    suspend fun groups(language: Language? = null): List<AchievementGroup> = allIds("${ACHIEVEMENTS}/${GROUPS}") {
        language(language)
    }

    /**
     * @return the ids of all achievement categories
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">the wiki</a>
     */
    suspend fun categoryIds(): List<AchievementCategoryId> = getIds(path = "${ACHIEVEMENTS}/${CATEGORIES}")

    /**
     * @return the achievement category associated with the [id]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">the wiki</a>
     */
    suspend fun category(id: AchievementCategoryId, language: Language? = null): AchievementCategory =
        getSingleById(id, "${ACHIEVEMENTS}/${CATEGORIES}", instance = { AchievementCategory(id = it) }) {
            language(language)
        }

    /**
     * @return the achievement categories associated with the [ids]
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">the wiki</a>
     */
    suspend fun categories(ids: Collection<AchievementCategoryId>, language: Language? = null): List<AchievementCategory> =
        chunkedIds(ids, "${ACHIEVEMENTS}/${CATEGORIES}", instance = { AchievementCategory(id = it) }) {
            language(language)
        }

    /**
     * @return all the achievement categories
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">the wiki</a>
     */
    suspend fun categories(language: Language? = null): List<AchievementCategory> =
        allIds("${ACHIEVEMENTS}/${CATEGORIES}") {
            language(language)
        }
}