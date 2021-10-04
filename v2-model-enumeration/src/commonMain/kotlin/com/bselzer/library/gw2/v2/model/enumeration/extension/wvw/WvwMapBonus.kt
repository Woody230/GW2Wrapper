package com.bselzer.library.gw2.v2.model.enumeration.extension.wvw

import com.bselzer.library.gw2.v2.model.enumeration.wvw.MapBonusType
import com.bselzer.library.gw2.v2.model.wvw.match.WvwMapBonus
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [WvwMapBonus.type] as a [MapBonusType]
 */
fun WvwMapBonus.type(): MapBonusType? = type.enumValueOrNull<MapBonusType>()