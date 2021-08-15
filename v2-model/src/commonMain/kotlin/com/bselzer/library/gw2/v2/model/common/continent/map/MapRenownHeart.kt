package com.bselzer.library.gw2.v2.model.common.continent.map

import com.bselzer.library.gw2.v2.model.common.extension.dimension.Point2D
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapRenownHeart(
    @SerialName("id")
    val id: Int = 0,

    /**
     * The description of the objective.
     */
    @SerialName("objective")
    val objective: String = "",

    /**
     * The recommended level of the heart.
     */
    @SerialName("level")
    val level: Int = 0,

    @SerialName("coord")
    val coordinates: Point2D = Point2D(),

    /**
     * The boundary of where the player can complete the heart.
     */
    @SerialName("bounds")
    val bounds: List<Point2D> = emptyList(),

    /**
     * The id of the chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Map_link">the wiki</a>
     */
    @SerialName("chat_link")
    val chatLink: String = ""
)