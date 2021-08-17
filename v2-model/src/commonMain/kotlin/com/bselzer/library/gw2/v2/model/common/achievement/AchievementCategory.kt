package com.bselzer.library.gw2.v2.model.common.achievement

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AchievementCategory(
    @SerialName("id")
    override val id: Int = 0,

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
    val iconLink: String = "",

    /**
     * The ids of achievements this category contains.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/achievements">the wiki</a>
     */
    @SerialName("achievements")
    val achievements: List<Int> = emptyList()
) : Identifiable<Int>