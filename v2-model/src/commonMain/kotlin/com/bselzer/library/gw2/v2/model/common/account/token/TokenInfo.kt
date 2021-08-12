package com.bselzer.library.gw2.v2.model.common.account.token

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The token information associated with an API key or another token.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">the wiki</a>
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
@Serializable
abstract class TokenInfo
{
    /**
     * The requested token id.
     */
    @SerialName("id")
    val id: String = ""

    /**
     * The name of the token, given by the owner.
     */
    @SerialName("name")
    val name: String = ""

    /**
     * The permissions accessible by the token.
     */
    @SerialName("permissions")
    val permissions: List<String> = emptyList()
}