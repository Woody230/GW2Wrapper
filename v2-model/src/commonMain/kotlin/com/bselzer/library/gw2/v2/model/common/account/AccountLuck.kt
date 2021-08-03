package com.bselzer.library.gw2.v2.model.common.account

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountLuck(
    /**
     * Will always be "luck" when retrieved from the API.
     */
    @SerialName("id")
    val id: String = "",

    /**
     * The amount of luck consumed.
     */
    @SerialName("value")
    val value: Int = 0
)