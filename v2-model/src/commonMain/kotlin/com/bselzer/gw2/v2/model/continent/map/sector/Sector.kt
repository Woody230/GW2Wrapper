package com.bselzer.gw2.v2.model.continent.map.sector

import com.bselzer.gw2.v2.model.wrapper.ChatLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sector(
    @SerialName("id")
    override val id: SectorId = SectorId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("level")
    val level: Int = 0,

    /**
     * The two-dimensional coordinates within the texture.
     */
    @SerialName("coord")
    val coordinates: List<Double> = emptyList(),

    /**
     * The boundary of this area represented by multiple two-dimensional coordinates.
     */
    @SerialName("bounds")
    val bounds: List<List<Double>> = emptyList(),

    /**
     * The id of the chat link.
     * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Map_link">the wiki</a>
     */
    @SerialName("chat_link")
    val chatLink: ChatLink = ChatLink()
) : Identifiable<Int>