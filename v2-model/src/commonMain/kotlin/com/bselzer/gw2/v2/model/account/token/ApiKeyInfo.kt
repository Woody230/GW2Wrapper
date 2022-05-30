package com.bselzer.gw2.v2.model.account.token

import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The information associated with an API key.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">the wiki</a>
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
@Serializable
@SerialName("APIKey")
data class ApiKeyInfo(
    /**
     * The requested token id.
     */
    @SerialName("id")
    override val id: ApiKey = ApiKey()
) : TokenInfo<ApiKey>()