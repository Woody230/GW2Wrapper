package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.WvwMapType
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner

/**
 * The [WvwMapType]'s associated [WvwObjectiveOwner].
 */
fun WvwMapType.owner(): WvwObjectiveOwner = when (this) {
    WvwMapType.ETERNAL_BATTLEGROUNDS -> WvwObjectiveOwner.NEUTRAL
    WvwMapType.RED_BORDERLANDS -> WvwObjectiveOwner.RED
    WvwMapType.BLUE_BORDERLANDS -> WvwObjectiveOwner.BLUE
    WvwMapType.GREEN_BORDERLANDS -> WvwObjectiveOwner.GREEN
    WvwMapType.EDGE_OF_THE_MISTS -> WvwObjectiveOwner.NEUTRAL
}