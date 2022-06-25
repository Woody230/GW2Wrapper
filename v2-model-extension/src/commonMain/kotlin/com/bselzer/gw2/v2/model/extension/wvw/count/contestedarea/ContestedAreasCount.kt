package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType

data class ContestedAreasCount(
    /**
     * The owner of the contested area and the objectives being counted.
     */
    val owner: WvwObjectiveOwner = WvwObjectiveOwner.NEUTRAL,

    /**
     * The type of objective being counted.
     */
    val type: WvwObjectiveType = WvwObjectiveType.GENERIC,

    /**
     * The number of objectives of [type].
     */
    val objectives: Int = 0,

    /**
     * The points that would currently be awarded to each [WvwObjectiveOwner] if a tick passed
     */
    val pointsPerTick: Int = 0,
)