package com.bselzer.library.gw2.v2.model.enumeration.extension.account

import com.bselzer.library.gw2.v2.model.account.mastery.AccountMasteryRegion
import com.bselzer.library.gw2.v2.model.enumeration.continent.RegionName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [AccountMasteryRegion.name] as a [RegionName]
 */
fun AccountMasteryRegion.name(): RegionName? = name.enumValueOrNull<RegionName>()