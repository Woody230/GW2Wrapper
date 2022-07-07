package com.bselzer.gw2.v2.model.continent.map.pointofinterest

import com.bselzer.gw2.v2.model.continent.floor.FloorId
import com.bselzer.gw2.v2.model.enumeration.wrapper.PointOfInterestType
import com.bselzer.gw2.v2.model.tile.position.TexturePosition
import com.bselzer.gw2.v2.model.wrapper.ChatLink
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PointOfInterest(
    @SerialName("id")
    override val id: PointOfInterestId = PointOfInterestId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("type")
    val type: PointOfInterestType = PointOfInterestType(),

    /**
     * The id of the floor this point of interest is located on.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/continents">the wiki</a>
     */
    @SerialName("floor")
    val floorId: FloorId = FloorId(),

    /**
     * The two-dimensional coordinates within the texture.
     */
    @SerialName("coord")
    val coordinates: TexturePosition = TexturePosition(),

    /**
     * The chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Map_link">the wiki</a>
     */
    @SerialName("chat_link")
    val chatLink: ChatLink = ChatLink(),

    /**
     * The link to the point of interest icon. Used for a [type] of "unlock".
     */
    @SerialName("icon")
    val iconLink: ImageLink = ImageLink()
) : Identifiable<PointOfInterestId, Int>