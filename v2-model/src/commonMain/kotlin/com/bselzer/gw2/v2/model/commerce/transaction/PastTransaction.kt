package com.bselzer.gw2.v2.model.commerce.transaction

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PastTransaction(
    /**
     * The date and time the item(s) were purchased.
     */
    @SerialName("purchased")
    val purchasedAt: Instant = Instant.DISTANT_PAST
) : BaseTransaction()