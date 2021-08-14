package com.bselzer.library.gw2.v2.model.extension.common.model.account

import com.bselzer.library.gw2.v2.model.common.account.AccountMaterial
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.scope.Binding
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [AccountMaterial.binding] as a [Binding]
 */
fun AccountMaterial.binding(): Binding? = binding?.enumValueOrNull<Binding>()