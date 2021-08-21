package com.bselzer.library.gw2.v2.model.extension.common.model.raid

import com.bselzer.library.gw2.v2.model.common.raid.RaidEvent
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.raid.RaidEventType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [RaidEvent.type] as a [RaidEventType]
 */
fun RaidEvent.type(): RaidEventType? = type.enumValueOrNull<RaidEventType>()