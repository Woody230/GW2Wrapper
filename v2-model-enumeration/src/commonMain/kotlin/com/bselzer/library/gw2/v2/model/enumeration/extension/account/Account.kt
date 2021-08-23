package com.bselzer.library.gw2.v2.model.enumeration.extension.account

import com.bselzer.library.gw2.v2.model.account.Account
import com.bselzer.library.gw2.v2.model.enumeration.scope.Access
import com.bselzer.library.kotlin.extension.serialization.function.validEnumValues
import kotlin.time.ExperimentalTime

/**
 * The [Account.access] as a collection of [Access]
 */
@ExperimentalTime
fun Account.access(): List<Access> = access.validEnumValues()