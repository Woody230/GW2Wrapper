package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.account.BankSlot
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.scope.Binding
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [BankSlot.binding] as a [Binding]
 */
fun BankSlot.binding(): Binding? = binding?.enumValueOrNull<Binding>()