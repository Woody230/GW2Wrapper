package com.bselzer.gw2.v2.model.wvw.match

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMatchStat(
    @SerialName("id")
    override val id: String = "",

    @SerialName("deaths")
    val deaths: WvwWorldCount = WvwWorldCount(),

    @SerialName("kills")
    val kills: WvwWorldCount = WvwWorldCount(),

    @SerialName("maps")
    val maps: List<WvwMap> = emptyList()
) : Identifiable<String>