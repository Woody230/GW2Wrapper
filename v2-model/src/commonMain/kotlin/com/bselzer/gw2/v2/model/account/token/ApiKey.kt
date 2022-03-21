package com.bselzer.gw2.v2.model.account.token

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

// TODO validation?
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
@Serializable
@JvmInline
value class ApiKey(override val value: String = "") : StringIdentifier