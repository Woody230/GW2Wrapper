package com.bselzer.library.gw2.v2.model.extension.common.model.account

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.model.common.account.token.TokenInfo
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

/**
 * The [TokenInfo.permissions] as a collection of [Permission]
 */
fun TokenInfo.permissions(): List<Permission> = permissions.validEnumValues()