package com.bselzer.gw2.v2.model.enumeration.scope

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Binding {
    /**
     * All characters on the account have access.
     */
    @SerialName("Account")
    ACCOUNT,

    /**
     * A single character on the account has access.
     */
    @SerialName("Character")
    CHARACTER
}