package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType
import com.bselzer.gw2.v2.model.enumeration.extension.enumValueOrNull
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective

class ContestedAreas internal constructor(objectives: Collection<WvwMapObjective>) {
    /**
     * The contested areas prioritized by the [WvwObjectiveOwner].
     */
    val byOwner = ContestedAreasByOwner(
        objectives.groupBy { objective ->
            objective.owner.enumValueOrNull() ?: WvwObjectiveOwner.NEUTRAL
        }.mapValues { (_, objectives) ->
            objectives.groupBy { objective ->
                objective.type.enumValueOrNull() ?: WvwObjectiveType.GENERIC
            }
        }
    )

    /**
     * The contested areas prioritized by the [WvwObjectiveType].
     */
    val byType = ContestedAreasByType(
        objectives.groupBy { objective ->
            objective.type.enumValueOrNull() ?: WvwObjectiveType.GENERIC
        }.mapValues { (_, objectives) ->
            objectives.groupBy { objective ->
                objective.owner.enumValueOrNull() ?: WvwObjectiveOwner.NEUTRAL
            }
        }
    )
}