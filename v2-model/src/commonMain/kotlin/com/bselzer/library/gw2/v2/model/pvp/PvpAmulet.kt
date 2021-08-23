package com.bselzer.library.gw2.v2.model.pvp

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpAmulet(
    @SerialName("id")
    override val id: Int,

    @SerialName("name")
    val name: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("attributes")
    val attributes: Map<String, Int> = emptyMap()
) : Identifiable<Int>