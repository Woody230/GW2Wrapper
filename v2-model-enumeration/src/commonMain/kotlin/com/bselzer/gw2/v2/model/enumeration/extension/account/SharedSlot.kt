package com.bselzer.gw2.v2.model.enumeration.extension.account

import com.bselzer.gw2.v2.model.account.slot.SharedSlot
import com.bselzer.gw2.v2.model.enumeration.scope.Binding
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [SharedSlot.binding] as a [Binding]
 */
fun SharedSlot.binding(): Binding? = binding?.enumValueOrNull<Binding>()