package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective
import kotlin.jvm.JvmStatic

abstract class ContestedAreasGrid internal constructor(
    val counts: List<List<ContestedAreasCount>>
) : List<List<ContestedAreasCount>> by counts {
    protected companion object {
        val WVW_OBJECTIVE_OWNERS: List<WvwObjectiveOwner> = WvwObjectiveOwner.values().toList()
        val WVW_OBJECTIVE_TYPES: List<WvwObjectiveType> = WvwObjectiveType.values().toList()

        @JvmStatic
        protected fun Collection<WvwMapObjective>.createCount(owner: WvwObjectiveOwner, type: WvwObjectiveType): ContestedAreasCount = ContestedAreasCount(
            owner = owner,
            type = type,
            objectives = this,
        )
    }
}