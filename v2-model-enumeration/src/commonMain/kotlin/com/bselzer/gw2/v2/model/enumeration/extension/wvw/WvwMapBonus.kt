package com.bselzer.gw2.v2.model.enumeration.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.wvw.MapBonusType
import com.bselzer.gw2.v2.model.enumeration.wvw.ObjectiveOwner
import com.bselzer.gw2.v2.model.wvw.map.WvwMapBonus
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [WvwMapBonus.type] as a [MapBonusType]
 */
fun WvwMapBonus.type(): MapBonusType? = type.enumValueOrNull<MapBonusType>()

/**
 * The [WvwMapBonus.owner] as an [ObjectiveOwner]
 */
fun WvwMapBonus.owner(): ObjectiveOwner? = owner.enumValueOrNull<ObjectiveOwner>()