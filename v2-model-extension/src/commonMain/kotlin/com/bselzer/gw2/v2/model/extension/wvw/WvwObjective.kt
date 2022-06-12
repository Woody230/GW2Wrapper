package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.gw2.v2.tile.model.position.TexturePosition

/**
 * @return the explicit coordinates if they exist, otherwise default to the label coordinates. This is needed for atypical types such as Spawn/Mercenary.
 */
fun WvwObjective.position(): TexturePosition {
    val coordinates = coordinates.toPoint2D()
    return if (!coordinates.isDefault) {
        TexturePosition(coordinates)
    } else {
        labelCoordinates
    }
}
