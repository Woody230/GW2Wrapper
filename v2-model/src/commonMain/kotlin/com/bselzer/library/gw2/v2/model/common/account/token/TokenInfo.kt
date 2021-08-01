package com.bselzer.library.gw2.v2.model.common.account.token

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The token information associated with an API key.
 *
 * Scopes: account
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">the wiki</a>
 */
@Serializable
abstract class TokenInfo
{
    /**
     * The requested token id.
     */
    @SerialName("id")
    abstract val id: String

    /**
     * The name of the token, given by the owner.
     */
    @SerialName("name")
    abstract val name: String

    /**
     * The permissions accessible by the token.
     */
    @SerialName("permissions")
    abstract val permissions: List<String>
}