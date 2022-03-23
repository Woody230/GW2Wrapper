package com.bselzer.gw2.v2.model.achievement.daily

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyAccess(
    /**
     * The required product.
     */
    @SerialName("product")
    val product: com.bselzer.gw2.v2.model.wrapper.Product = com.bselzer.gw2.v2.model.wrapper.Product(),

    /**
     * Whether the account needs to have or not have access to the product to be able to access the achievement.
     */
    @SerialName("condition")
    val accessibility: com.bselzer.gw2.v2.model.wrapper.Accessibility = com.bselzer.gw2.v2.model.wrapper.Accessibility()
)