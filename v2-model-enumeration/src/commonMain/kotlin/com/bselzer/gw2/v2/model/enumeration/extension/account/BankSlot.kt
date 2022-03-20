package com.bselzer.gw2.v2.model.enumeration.extension.account

import com.bselzer.gw2.v2.model.account.slot.BankSlot
import com.bselzer.gw2.v2.model.enumeration.scope.Binding
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [BankSlot.binding] as a [Binding]
 */
fun BankSlot.binding(): Binding? = binding?.enumValueOrNull<Binding>()