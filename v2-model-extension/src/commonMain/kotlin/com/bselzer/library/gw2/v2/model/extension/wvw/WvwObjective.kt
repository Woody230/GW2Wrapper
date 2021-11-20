package com.bselzer.library.gw2.v2.model.extension.wvw

import com.bselzer.library.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.library.kotlin.extension.geometry.dimension.bi.position.Point2D

/**
 * @return the [WvwObjective.id] broken into its parts: the map and objective ids.
 */
fun WvwObjective.id(): Pair<Int, Int>
{
    val parts = id.split("-")
    return Pair(parts.getOrNull(0)?.toIntOrNull() ?: -1, parts.getOrNull(1)?.toIntOrNull() ?: -1)
}

/**
 * @return the map id within the [WvwObjective.id]
 */
fun WvwObjective.mapId(): Int = id().first

/**
 * @return the objective id within the [WvwObjective.id]
 */
fun WvwObjective.objectiveId(): Int = id().second

/**
 * @return the explicit coordinates if they exist, otherwise default to the label coordinates. This is needed for atypical types such as Spawn/Mercenary.
 */
fun WvwObjective.coordinates(): Point2D = if (coordinates.x != 0.0 && coordinates.y != 0.0) Point2D(coordinates.x, coordinates.y) else labelCoordinates