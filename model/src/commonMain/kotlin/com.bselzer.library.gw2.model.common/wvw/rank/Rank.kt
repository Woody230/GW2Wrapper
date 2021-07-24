package com.bselzer.library.gw2.model.common.wvw.rank

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rank(
    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("min_rank")
    val minRank: Int
)