package com.bselzer.library.gw2.v2.model.enumeration.extension.account

import com.bselzer.library.gw2.v2.model.account.AccountMaterial
import com.bselzer.library.gw2.v2.model.enumeration.scope.Binding
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [AccountMaterial.binding] as a [Binding]
 */
fun AccountMaterial.binding(): Binding? = binding?.enumValueOrNull<Binding>()