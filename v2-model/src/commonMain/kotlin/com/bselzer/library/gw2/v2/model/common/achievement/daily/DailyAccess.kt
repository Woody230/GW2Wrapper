package com.bselzer.library.gw2.v2.model.common.achievement.daily

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyAccess(
    /**
     * The required product.
     */
    @SerialName("product")
    val product: String = "",

    /**
     * Whether the account has access to this achievement.
     */
    @SerialName("condition")
    val accessibility: String = ""
)