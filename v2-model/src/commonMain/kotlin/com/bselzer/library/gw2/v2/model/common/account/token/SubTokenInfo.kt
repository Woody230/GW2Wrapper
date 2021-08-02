package com.bselzer.library.gw2.v2.model.common.account.token

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import com.bselzer.library.kotlin.extension.datetime.common.function.minValue
import kotlinx.datetime.LocalDateTime
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
    override val id: String,
    override val name: String,
    override val permissions: List<String>,

    /**
     * The expiration date.
     */
    @SerialName("expires_at")
    val expiresAt: LocalDateTime = LocalDateTime.minValue(),

    /**
     * The creation date.
     */
    @SerialName("issued_at")
    val issuedAt: LocalDateTime = LocalDateTime.minValue(),

    /**
     * The collection of available endpoints if the token is restricted.
     */
    @SerialName("urls")
    val urls: List<String> = emptyList()
) : TokenInfo()