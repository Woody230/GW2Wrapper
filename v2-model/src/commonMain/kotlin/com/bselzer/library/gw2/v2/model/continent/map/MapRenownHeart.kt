package com.bselzer.library.gw2.v2.model.continent.map

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapRenownHeart(
    @SerialName("id")
    override val id: Int = 0,

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
    val coordinates: Point = Point(),

    /**
     * The boundary of where the player can complete the heart.
     */
    @SerialName("bounds")
    val bounds: List<Point> = emptyList(),

    /**
     * The id of the chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Map_link">the wiki</a>
     */
    @SerialName("chat_link")
    val chatLink: String = ""
) : Identifiable<Int>