package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.account.bank.BankItemStat
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.AttributeName
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

/**
 * The [BankItemStat.attributes] with [AttributeName] keys
 */
fun BankItemStat.attributes(): Map<AttributeName, Double> = attributes.validEnumValues()