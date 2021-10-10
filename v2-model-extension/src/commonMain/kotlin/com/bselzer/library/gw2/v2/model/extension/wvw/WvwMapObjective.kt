package com.bselzer.library.gw2.v2.model.extension.wvw

import com.bselzer.library.gw2.v2.model.wvw.match.WvwMapObjective

/**
 * @return the [WvwMapObjective.id] broken into its parts: the map and objective ids.
 */
fun WvwMapObjective.id(): Pair<Int, Int>
{
    val parts = id.split("-")
    return Pair(parts.getOrNull(0)?.toIntOrNull() ?: -1, parts.getOrNull(1)?.toIntOrNull() ?: -1)
}

/**
 * @return the map id within the [WvwMapObjective.id]
 */
fun WvwMapObjective.mapId(): Int = id().first

/**
 * @return the objective id within the [WvwMapObjective.id]
 */
fun WvwMapObjective.objectiveId(): Int = id().second