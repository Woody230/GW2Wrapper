package com.bselzer.library.gw2.v2.model.extension.common.model.account

import com.bselzer.library.gw2.v2.model.common.account.SharedSlot
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.scope.Binding
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [SharedSlot.binding] as a [Binding]
 */
fun SharedSlot.binding(): Binding? = binding?.enumValueOrNull<Binding>()