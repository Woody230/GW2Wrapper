package com.bselzer.gw2.v2.model.account.token

import com.bselzer.gw2.v2.model.wrapper.Url
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The sub-token information associated with an API key or another token.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">the wiki</a>
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
@Serializable
@SerialName("Subtoken")
data class SubTokenInfo(
    /**
     * The requested token id.
     */
    @SerialName("id")
    override val id: SubToken,

    /**
     * The expiration date.
     */
    @SerialName("expires_at")
    val expiresAt: Instant = Instant.DISTANT_PAST,

    /**
     * The creation date.
     */
    @SerialName("issued_at")
    val issuedAt: Instant = Instant.DISTANT_PAST,

    /**
     * The collection of available endpoints if the token is restricted.
     */
    @SerialName("urls")
    val urls: List<Url> = emptyList()
) : TokenInfo()