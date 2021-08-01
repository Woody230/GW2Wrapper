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
     * Whether the account needs to have or not have access to the product to be able to access the achievement.
     */
    @SerialName("condition")
    val accessibility: String = ""
)