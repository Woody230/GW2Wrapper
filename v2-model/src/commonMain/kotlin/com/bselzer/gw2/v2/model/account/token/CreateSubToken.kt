package com.bselzer.gw2.v2.model.account.token

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateSubToken(
    @SerialName("subtoken")
    val subtoken: SubToken
)