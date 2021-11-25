package com.bselzer.library.gw2.v2.model.extension.wvw

import com.bselzer.library.gw2.v2.model.enumeration.wvw.MapType
import com.bselzer.library.gw2.v2.model.enumeration.wvw.ObjectiveOwner

/**
 * The [MapType]'s associated [ObjectiveOwner].
 */
fun MapType.owner(): ObjectiveOwner = when (this) {
    MapType.ETERNAL_BATTLEGROUNDS -> ObjectiveOwner.NEUTRAL
    MapType.RED_BORDERLANDS -> ObjectiveOwner.RED
    MapType.BLUE_BORDERLANDS -> ObjectiveOwner.BLUE
    MapType.GREEN_BORDERLANDS -> ObjectiveOwner.GREEN
    MapType.EDGE_OF_THE_MISTS -> ObjectiveOwner.NEUTRAL
}