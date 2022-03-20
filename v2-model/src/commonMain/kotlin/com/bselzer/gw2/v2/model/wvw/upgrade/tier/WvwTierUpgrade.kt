package com.bselzer.gw2.v2.model.wvw.upgrade.tier

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwTierUpgrade(
    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = ""
)