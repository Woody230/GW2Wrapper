package com.bselzer.library.gw2.v2.model.enumeration.extension.account

import com.bselzer.library.gw2.v2.model.account.token.TokenInfo
import com.bselzer.library.gw2.v2.scope.core.Permission
import com.bselzer.library.kotlin.extension.serialization.function.validEnumValues

/**
 * The [TokenInfo.permissions] as a collection of [Permission]
 */
fun TokenInfo.permissions(): List<Permission> = permissions.validEnumValues()