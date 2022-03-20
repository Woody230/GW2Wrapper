package com.bselzer.gw2.v2.model.story.season

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.story.StoryId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StorySeason(
    /**
     * The id of the season in the form of a UUID.
     */
    @SerialName("id")
    override val id: StorySeasonId = StorySeasonId(),

    @SerialName("name")
    val name: String = "",

    /**
     * The order in which this season gets displayed in the story journal.
     */
    @SerialName("order")
    val order: Int = 0,

    /**
     * The ids of the stories that belong to this season.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/stories/seasons">the wiki</a>
     */
    @SerialName("stories")
    val storyIds: List<StoryId> = emptyList()
) : Identifiable<String>