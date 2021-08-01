package com.bselzer.library.gw2.v2.model.common.achievement

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AchievementGroup(
    /**
     * The identifier in the form of a UUID.
     */
    @SerialName("id")
    val id: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    /**
     * The order of this group among other groups. The lower the order, the higher the priority.
     */
    @SerialName("order")
    val order: Int = Int.MAX_VALUE,

    /**
     * The ids of achievement categories.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements/categories">the wiki</a>
     */
    @SerialName("categories")
    val categories: List<Int> = emptyList()
)