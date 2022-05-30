package com.bselzer.gw2.v2.model.continent.map.heart

import com.bselzer.gw2.v2.model.character.CharacterLevel
import com.bselzer.gw2.v2.model.wrapper.ChatLink
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RenownHeart(
    @SerialName("id")
    override val id: RenownHeartId = RenownHeartId(),

    /**
     * The description of the objective.
     */
    @SerialName("objective")
    val objective: String = "",

    /**
     * The recommended level of the heart.
     */
    @SerialName("level")
    val level: CharacterLevel = CharacterLevel(),

    /**
     * The two-dimensional coordinates within the texture.
     */
    @SerialName("coord")
    val coordinates: Point2D = Point2D(),

    /**
     * The boundary of where the player can complete the heart represented by two-dimensional coordinates.
     */
    @SerialName("bounds")
    val bounds: List<Point2D> = emptyList(),

    /**
     * The id of the chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Map_link">the wiki</a>
     */
    @SerialName("chat_link")
    val chatLink: ChatLink = ChatLink()
) : Identifiable<RenownHeartId, Int>