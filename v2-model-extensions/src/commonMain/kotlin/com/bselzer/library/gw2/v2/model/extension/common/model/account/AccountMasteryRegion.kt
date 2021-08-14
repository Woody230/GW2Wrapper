package com.bselzer.library.gw2.v2.model.extension.common.model.account

import com.bselzer.library.gw2.v2.model.common.account.mastery.AccountMasteryRegion
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.map.Region
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [AccountMasteryRegion.name] as a [Region]
 */
fun AccountMasteryRegion.name(): Region? = name.enumValueOrNull<Region>()