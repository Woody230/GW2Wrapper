package com.bselzer.gw2.v2.model.account.luck

import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountLuck(
    @SerialName("id")
    override val id: LuckId = LuckId(),

    /**
     * The amount of luck consumed.
     */
    @SerialName("value")
    val value: Int = 0
) : Identifiable<String>