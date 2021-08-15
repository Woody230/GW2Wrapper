package com.bselzer.library.gw2.v2.model.common.commerce.delivery

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.TRADING_POST)
data class Delivery(
    /**
     * The amount of copper coins ready for pickup.
     */
    @SerialName("coins")
    val coins: Int = 0,

    /**
     * The items ready for pickup.
     */
    @SerialName("items")
    val items: List<DeliveryItem> = emptyList()
)