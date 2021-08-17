package com.bselzer.library.gw2.v2.model.common.wvw.match

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MatchStat(
    @SerialName("id")
    override val id: String = "",

    @SerialName("deaths")
    val deaths: WorldCount = WorldCount(),

    @SerialName("kills")
    val kills: WorldCount = WorldCount(),

    @SerialName("maps")
    val maps: List<Map> = emptyList()
) : Identifiable<String>