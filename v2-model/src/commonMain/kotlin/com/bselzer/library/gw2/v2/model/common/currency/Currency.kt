package com.bselzer.library.gw2.v2.model.common.currency

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Currency(
    @SerialName("id")
    val id: Int = 0,

    // TODO enum and extension
    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: String = "",

    /**
     * The order of appearance among all currencies. A collection of currencies should be ordered from least to greatest.
     */
    @SerialName("order")
    val order: Int = 0
)