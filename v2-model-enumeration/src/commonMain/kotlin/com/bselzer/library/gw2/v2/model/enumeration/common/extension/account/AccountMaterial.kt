package com.bselzer.library.gw2.v2.model.enumeration.common.extension.account

import com.bselzer.library.gw2.v2.model.common.account.AccountMaterial
import com.bselzer.library.gw2.v2.model.enumeration.common.scope.Binding
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [AccountMaterial.binding] as a [Binding]
 */
fun AccountMaterial.binding(): Binding? = binding?.enumValueOrNull<Binding>()