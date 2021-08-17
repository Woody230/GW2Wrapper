package com.bselzer.library.gw2.v2.model.common.quest

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quest(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    /**
     * The minimum level required to begin this quest.
     */
    @SerialName("level")
    val level: Int = 0,

    /**
     * The id of the story.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    @SerialName("story")
    val storyId: String = "",

    @SerialName("goals")
    val goals: List<QuestGoal> = emptyList()
) : Identifiable<Int>