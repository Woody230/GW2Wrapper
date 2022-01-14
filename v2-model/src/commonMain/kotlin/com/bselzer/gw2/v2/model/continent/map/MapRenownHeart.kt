package com.bselzer.gw2.v2.model.continent.map

import com.bselzer.gw2.v2.model.extension.base.Identifiable
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

    /**
     * The two-dimensional coordinates within the texture.
     */
    @SerialName("coord")
    val coordinates: List<Double> = emptyList(),

    /**
     * The boundary of where the player can complete the heart represented by two-dimensional coordinates.
     */
    @SerialName("bounds")
    val bounds: List<List<Double>> = emptyList(),

    /**
     * The id of the chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Map_link">the wiki</a>
     */
    @SerialName("chat_link")
    val chatLink: String = ""
) : Identifiable<Int>