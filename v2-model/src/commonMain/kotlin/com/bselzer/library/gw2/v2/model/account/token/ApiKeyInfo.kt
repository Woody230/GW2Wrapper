package com.bselzer.library.gw2.v2.model.account.token

import com.bselzer.library.gw2.v2.scope.core.Permission
import com.bselzer.library.gw2.v2.scope.core.Requirement
import com.bselzer.library.gw2.v2.scope.core.Scope
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
class ApiKeyInfo : TokenInfo()