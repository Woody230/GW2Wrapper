package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType
import com.bselzer.gw2.v2.model.enumeration.extension.enumValueOrNull
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective

abstract class ContestedAreasGrid(
    private val objectives: Collection<WvwMapObjective>
) {
    abstract val counts: List<List<ContestedAreasCount>>

    protected fun createCount(owner: WvwObjectiveOwner, type: WvwObjectiveType): ContestedAreasCount = run {
        val objectives = objectives.filter { objective -> objective.owner.enumValueOrNull() == owner && objective.type.enumValueOrNull() == type }
        ContestedAreasCount(
            owner = owner,
            type = type,
            objectives = objectives.count(),
            pointsPerTick = objectives.sumOf { objective -> objective.pointsPerTick }
        )
    }

    protected companion object {
        val WVW_OBJECTIVE_OWNERS: List<WvwObjectiveOwner> = WvwObjectiveOwner.values().toList()
        val WVW_OBJECTIVE_TYPES: List<WvwObjectiveType> = WvwObjectiveType.values().toList()
    }
}