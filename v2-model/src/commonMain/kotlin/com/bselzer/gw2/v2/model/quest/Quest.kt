package com.bselzer.gw2.v2.model.quest

import com.bselzer.gw2.v2.model.character.CharacterLevel
import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.story.StoryId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quest(
    @SerialName("id")
    override val id: QuestId = QuestId(),

    @SerialName("name")
    val name: String = "",

    /**
     * The minimum level required to begin this quest.
     */
    @SerialName("level")
    val level: CharacterLevel = CharacterLevel(),

    /**
     * The id of the story.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories">the wiki</a>
     */
    @SerialName("story")
    val storyId: StoryId = StoryId(),

    @SerialName("goals")
    val goals: List<QuestGoal> = emptyList()
) : Identifiable<Int>