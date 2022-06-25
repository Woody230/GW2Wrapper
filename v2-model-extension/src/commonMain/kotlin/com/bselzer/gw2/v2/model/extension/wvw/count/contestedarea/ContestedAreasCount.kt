package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType
import com.bselzer.gw2.v2.model.enumeration.extension.enumValueOrNull
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective

class ContestedAreasCount(
    /**
     * The owner of the contested area and the objectives being counted.
     */
    val owner: WvwObjectiveOwner = WvwObjectiveOwner.NEUTRAL,

    /**
     * The type of objective being counted.
     */
    val type: WvwObjectiveType = WvwObjectiveType.GENERIC,

    /**
     * The objectives to filter for the particular [owner] and [type].
     */
    objectives: Collection<WvwMapObjective> = emptyList()
) : Collection<WvwMapObjective> by objectives.filtered(owner, type) {
    private companion object {
        /**
         * The objectives of [type] that are owned by [owner].
         */
        fun Collection<WvwMapObjective>.filtered(owner: WvwObjectiveOwner, type: WvwObjectiveType): Collection<WvwMapObjective> {
            return filter { objective -> objective.owner.enumValueOrNull() == owner && objective.type.enumValueOrNull() == type }
        }
    }

    /**
     * The points that would currently be awarded to the [owner] if a tick passed
     */
    val pointsPerTick: Int = sumOf { objective -> objective.pointsPerTick }

    /**
     * The total number of yaks delivered to the objectives.
     */
    val yaksDelivered: Int = sumOf { objective -> objective.yaksDelivered }
}