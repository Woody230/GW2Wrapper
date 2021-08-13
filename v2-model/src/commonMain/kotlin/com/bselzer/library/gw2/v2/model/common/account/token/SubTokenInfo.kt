package com.bselzer.library.gw2.v2.model.common.account.token

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
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
    val urls: List<String> = emptyList()
) : TokenInfo()