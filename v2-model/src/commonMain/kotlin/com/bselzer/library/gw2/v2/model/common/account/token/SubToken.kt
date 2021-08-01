package com.bselzer.library.gw2.v2.model.common.account.token

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The sub-token.
 *
 * Scopes: account
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
 */
@Serializable
data class SubToken(
    @SerialName("subtoken")
    val id: String = ""
)