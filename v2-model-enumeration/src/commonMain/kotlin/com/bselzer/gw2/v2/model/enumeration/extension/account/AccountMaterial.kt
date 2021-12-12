package com.bselzer.gw2.v2.model.enumeration.extension.account

import com.bselzer.gw2.v2.model.account.AccountMaterial
import com.bselzer.gw2.v2.model.enumeration.scope.Binding
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [AccountMaterial.binding] as a [Binding]
 */
fun AccountMaterial.binding(): Binding? = binding?.enumValueOrNull<Binding>()