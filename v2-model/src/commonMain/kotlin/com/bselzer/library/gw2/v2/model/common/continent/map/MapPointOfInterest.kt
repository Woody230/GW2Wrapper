package com.bselzer.library.gw2.v2.model.common.continent.map

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import com.bselzer.library.gw2.v2.model.common.extension.dimension.Point2D
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapPointOfInterest(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("type")
    val type: String = "",

    /**
     * The id of the floor this point of interest is located on.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    @SerialName("floor")
    val floorId: Int = 0,

    @SerialName("coord")
    val coordinates: Point2D = Point2D(),

    /**
     * The chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Map_link">the wiki</a>
     */
    @SerialName("chat_link")
    val chatLink: String = "",

    /**
     * The link to the point of interest icon. Used for a [type] of "unlock".
     */
    @SerialName("icon")
    val iconLink: String = ""
) : Identifiable<Int>