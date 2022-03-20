package com.bselzer.gw2.v2.model.enumeration.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.wvw.ObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.wvw.ObjectiveType
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [WvwMapObjective.type] as an [ObjectiveType]
 */
fun WvwMapObjective.type(): ObjectiveType? = type.enumValueOrNull<ObjectiveType>()

/**
 * The [WvwMapObjective.owner] as an [ObjectiveOwner]
 */
fun WvwMapObjective.owner(): ObjectiveOwner? = owner.enumValueOrNull<ObjectiveOwner>()