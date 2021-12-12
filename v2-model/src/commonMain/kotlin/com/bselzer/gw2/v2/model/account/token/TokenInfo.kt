package com.bselzer.gw2.v2.model.account.token

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The token information associated with an API key or another token.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">the wiki</a>
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
@Serializable
abstract class TokenInfo(
    /**
     * The requested token id.
     */
    @SerialName("id")
    override val id: String = "",

    /**
     * The name of the token, given by the owner.
     */
    @SerialName("name")
    val name: String = "",

    /**
     * The permissions accessible by the token.
     */
    @SerialName("permissions")
    val permissions: List<String> = emptyList()
) : Identifiable<String> {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as TokenInfo

        if (id != other.id) return false
        if (name != other.name) return false
        if (permissions != other.permissions) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + permissions.hashCode()
        return result
    }
}