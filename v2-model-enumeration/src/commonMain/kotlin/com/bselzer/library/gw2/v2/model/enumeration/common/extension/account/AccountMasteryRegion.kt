package com.bselzer.library.gw2.v2.model.enumeration.common.extension.account

import com.bselzer.library.gw2.v2.model.common.account.mastery.AccountMasteryRegion
import com.bselzer.library.gw2.v2.model.enumeration.common.continent.RegionName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [AccountMasteryRegion.name] as a [RegionName]
 */
fun AccountMasteryRegion.name(): RegionName? = name.enumValueOrNull<RegionName>()