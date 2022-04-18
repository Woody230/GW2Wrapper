package com.bselzer.gw2.v2.model.achievement

import com.bselzer.gw2.v2.model.enumeration.wrapper.Accessibility
import com.bselzer.gw2.v2.model.enumeration.wrapper.Product
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AchievementAccess(
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