package com.bselzer.gw2.v2.model.enumeration.extension.account

import com.bselzer.gw2.v2.model.account.token.TokenInfo
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [TokenInfo.permissions] as a collection of [Permission]
 */
fun TokenInfo.permissions(): List<Permission> = permissions.validEnumValues()