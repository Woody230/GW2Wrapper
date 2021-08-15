package com.bselzer.library.gw2.v2.model.common.wvw.rank

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwRank(
    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("min_rank")
    val minRank: Int
)