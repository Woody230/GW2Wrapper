package com.bselzer.gw2.v2.model.account.token

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The sub-token.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
@Serializable
@JvmInline
value class SubToken(override val value: String) : StringIdentifier {
    override fun toString(): String = value
}