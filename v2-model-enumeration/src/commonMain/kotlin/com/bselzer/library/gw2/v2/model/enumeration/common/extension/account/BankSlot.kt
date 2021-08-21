package com.bselzer.library.gw2.v2.model.enumeration.common.extension.account

import com.bselzer.library.gw2.v2.model.common.account.BankSlot
import com.bselzer.library.gw2.v2.model.enumeration.common.scope.Binding
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [BankSlot.binding] as a [Binding]
 */
fun BankSlot.binding(): Binding? = binding?.enumValueOrNull<Binding>()