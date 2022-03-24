package com.bselzer.gw2.v2.model.wvw.rank

import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwRank(
    @SerialName("id")
    override val id: WvwRankId = WvwRankId(),

    @SerialName("title")
    val title: String = "",

    @SerialName("min_rank")
    val minRank: WvwLevel = WvwLevel()
) : Identifiable<Int>