package com.bselzer.gw2.v2.model.enumeration.extension.raid

import com.bselzer.gw2.v2.model.enumeration.raid.RaidEventType
import com.bselzer.gw2.v2.model.raid.RaidEvent
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [RaidEvent.type] as a [RaidEventType]
 */
fun RaidEvent.type(): RaidEventType? = type.enumValueOrNull<RaidEventType>()