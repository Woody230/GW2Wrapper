package com.bselzer.gw2.v2.model.achievement.daily

import com.bselzer.gw2.v2.model.wrapper.Accessibility
import com.bselzer.gw2.v2.model.wrapper.Product
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyAccess(
    /**
     * The required product.
     */
    @SerialName("product")
    val product: Product = Product(),

    /**
     * Whether the account needs to have or not have access to the product to be able to access the achievement.
     */
    @SerialName("condition")
    val accessibility: Accessibility = Accessibility()
)