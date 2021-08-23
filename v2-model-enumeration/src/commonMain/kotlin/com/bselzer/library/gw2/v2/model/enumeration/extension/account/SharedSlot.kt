package com.bselzer.library.gw2.v2.model.enumeration.extension.account

import com.bselzer.library.gw2.v2.model.account.SharedSlot
import com.bselzer.library.gw2.v2.model.enumeration.scope.Binding
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [SharedSlot.binding] as a [Binding]
 */
fun SharedSlot.binding(): Binding? = binding?.enumValueOrNull<Binding>()