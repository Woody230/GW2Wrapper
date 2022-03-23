package com.bselzer.gw2.v2.model.pvp.amulet

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.wrapper.AttributeName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpAmulet(
    @SerialName("id")
    override val id: PvpAmuletId = PvpAmuletId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    /**
     * The name of the attribute mapped to the amount it is increased by.
     */
    @SerialName("attributes")
    val attributes: Map<AttributeName, Int> = emptyMap()
) : Identifiable<Int>