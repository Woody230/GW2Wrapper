package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.account.Account
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.scope.Access
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues
import kotlin.time.ExperimentalTime

/**
 * The [Account.access] as a collection of [Access]
 */
@ExperimentalTime
fun Account.access(): List<Access> = access.validEnumValues()