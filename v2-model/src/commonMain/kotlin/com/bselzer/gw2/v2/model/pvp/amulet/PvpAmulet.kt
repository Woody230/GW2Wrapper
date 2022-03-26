package com.bselzer.gw2.v2.model.pvp.amulet

import com.bselzer.gw2.v2.model.enumeration.wrapper.AttributeName
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpAmulet(
    @SerialName("id")
    override val id: PvpAmuletId = PvpAmuletId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    /**
     * The name of the attribute mapped to the amount it is increased by.
     */
    @SerialName("attributes")
    val attributes: Map<AttributeName, Int> = emptyMap()
) : Identifiable<Int>