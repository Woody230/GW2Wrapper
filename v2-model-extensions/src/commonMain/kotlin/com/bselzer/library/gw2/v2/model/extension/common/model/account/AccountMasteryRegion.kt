package com.bselzer.library.gw2.v2.model.extension.common.model.account

import com.bselzer.library.gw2.v2.model.common.account.mastery.AccountMasteryRegion
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.continent.RegionName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [AccountMasteryRegion.name] as a [RegionName]
 */
fun AccountMasteryRegion.name(): RegionName? = name.enumValueOrNull<RegionName>()