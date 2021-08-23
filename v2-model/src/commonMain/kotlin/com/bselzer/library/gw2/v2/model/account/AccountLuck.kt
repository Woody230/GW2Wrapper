package com.bselzer.library.gw2.v2.model.account

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountLuck(
    /**
     * Will always be "luck" when retrieved from the API.
     */
    @SerialName("id")
    override val id: String = "",

    /**
     * The amount of luck consumed.
     */
    @SerialName("value")
    val value: Int = 0
) : Identifiable<String>