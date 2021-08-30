package com.bselzer.library.gw2.v2.model.account.token

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.gw2.v2.scope.core.Permission
import com.bselzer.library.gw2.v2.scope.core.Requirement
import com.bselzer.library.gw2.v2.scope.core.Scope
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The sub-token.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
@Serializable
data class SubToken(
    @SerialName("subtoken")
    override val id: String = ""
) : Identifiable<String>