package com.bselzer.library.gw2.v2.model.extension.wvw

import com.bselzer.library.gw2.v2.model.wvw.objective.WvwObjective

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