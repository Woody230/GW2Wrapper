package com.bselzer.library.gw2.v2.model.common.continent.map

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import com.bselzer.library.gw2.v2.model.common.extension.dimension.Point2D
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapSector(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("level")
    val level: Int = 0,

    /**
     * The coordinates of this area, typically at the center.
     */
    @SerialName("coord")
    val coordinates: Point2D = Point2D(),

    /**
     * The boundary of this area.
     */
    @SerialName("bounds")
    val bounds: List<Point2D> = emptyList(),

    /**
     * The id of the chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Map_link">the wiki</a>
     */
    @SerialName("chat_link")
    val chatLink: String = ""
) : Identifiable<Int>