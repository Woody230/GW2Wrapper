package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.account.bank.BankItem
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.scope.Binding
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [BankItem.binding] as a [Binding]
 */
fun BankItem.binding(): Binding? = binding?.enumValueOrNull<Binding>()