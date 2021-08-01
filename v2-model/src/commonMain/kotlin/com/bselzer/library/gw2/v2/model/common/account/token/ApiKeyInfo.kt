package com.bselzer.library.gw2.v2.model.common.account.token

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The information associated with an API key.
 *
 * Scopes: account
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">the wiki</a>
 */
@Serializable
@SerialName("APIKey")
data class ApiKeyInfo(
    override val id: String,
    override val name: String,
    override val permissions: List<String>
) : TokenInfo()