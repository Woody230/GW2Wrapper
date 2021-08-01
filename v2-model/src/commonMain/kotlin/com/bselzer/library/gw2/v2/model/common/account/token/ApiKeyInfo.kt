package com.bselzer.library.gw2.v2.model.common.account.token

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("APIKey")
data class ApiKeyInfo(
    override val id: String,
    override val name: String,
    override val permissions: List<String>
) : TokenInfo()