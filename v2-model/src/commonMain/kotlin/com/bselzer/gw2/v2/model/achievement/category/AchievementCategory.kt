package com.bselzer.gw2.v2.model.achievement.category

import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AchievementCategory(
    @SerialName("id")
    override val id: AchievementCategoryId = AchievementCategoryId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    /**
     * The order of this category among other categories. The lower the order, the higher the priority.
     */
    @SerialName("order")
    val order: Int = Int.MAX_VALUE,

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    /**
     * The cu
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    @SerialName("achievements")
    val achievements: List<CategoryAchievement> = emptyList(),

    @SerialName("tomorrow")
    val tomorrow: List<CategoryAchievement> = emptyList()
) : Identifiable<AchievementCategoryId, Int>