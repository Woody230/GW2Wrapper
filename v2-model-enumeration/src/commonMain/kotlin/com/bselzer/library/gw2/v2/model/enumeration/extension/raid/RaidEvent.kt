package com.bselzer.library.gw2.v2.model.enumeration.extension.raid

import com.bselzer.library.gw2.v2.model.enumeration.raid.RaidEventType
import com.bselzer.library.gw2.v2.model.raid.RaidEvent
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [RaidEvent.type] as a [RaidEventType]
 */
fun RaidEvent.type(): RaidEventType? = type.enumValueOrNull<RaidEventType>()