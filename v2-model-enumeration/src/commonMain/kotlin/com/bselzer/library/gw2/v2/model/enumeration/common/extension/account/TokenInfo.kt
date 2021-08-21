package com.bselzer.library.gw2.v2.model.enumeration.common.extension.account

import com.bselzer.library.gw2.v2.model.common.account.token.TokenInfo
import com.bselzer.library.gw2.v2.scope.common.core.Permission
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [TokenInfo.permissions] as a collection of [Permission]
 */
fun TokenInfo.permissions(): List<Permission> = permissions.validEnumValues()