package com.bselzer.library.gw2.v2.model.common.wvw.rank

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwRank(
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("title")
    val title: String = "",

    @SerialName("min_rank")
    val minRank: Int = 0
) : Identifiable<Int>