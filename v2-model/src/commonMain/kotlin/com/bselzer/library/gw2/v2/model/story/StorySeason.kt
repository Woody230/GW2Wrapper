package com.bselzer.library.gw2.v2.model.story

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StorySeason(
    /**
     * The id of the season in the form of a UUID.
     */
    @SerialName("id")
    override val id: String = "",

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
    val storyIds: List<Int> = emptyList()
) : Identifiable<String>