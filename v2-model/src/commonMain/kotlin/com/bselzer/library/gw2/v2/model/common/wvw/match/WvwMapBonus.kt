package com.bselzer.library.gw2.v2.model.common.wvw.match

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwMapBonus(
    @SerialName("type")
    val type: String = "",

    @SerialName("owner")
    val owner: String = ""
)