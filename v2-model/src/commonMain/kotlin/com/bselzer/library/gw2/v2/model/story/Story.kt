package com.bselzer.library.gw2.v2.model.story

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Story(
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The id of the story season.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    @SerialName("season")
    val seasonId: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    /**
     * The in-game date this story occurs at.
     */
    @SerialName("timeline")
    val timeline: String = "",

    /**
     * The minimum level required to begin this story.
     */
    @SerialName("level")
    val level: Int = 0,

    /**
     * The order this story gets displayed in the story journal.
     */
    @SerialName("order")
    val order: Int = 0,

    @SerialName("chapters")
    val chapters: List<StoryChapter> = emptyList(),

    /**
     * The names of the races that can participate in this story.
     *
     * Empty if there are no race requirements.
     */
    @SerialName("races")
    val races: List<String> = emptyList(),

    /**
     * The flags for additional requirements for being able to participate in this story.
     *
     * Empty if there are no additional requirements.
     */
    @SerialName("flags")
    val flags: List<String> = emptyList()
) : Identifiable<Int>