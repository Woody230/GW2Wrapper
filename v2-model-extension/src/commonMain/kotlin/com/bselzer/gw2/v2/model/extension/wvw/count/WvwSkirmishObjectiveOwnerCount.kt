package com.bselzer.gw2.v2.model.extension.wvw.count

import com.bselzer.gw2.v2.model.enumeration.WvwMapType
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.extension.decodeOrNull
import com.bselzer.gw2.v2.model.wvw.match.skirmish.WvwSkirmish

class WvwSkirmishObjectiveOwnerCount internal constructor(
    /**
     * The score within the [WvwSkirmish.scores] for each [WvwObjectiveOwner]
     */
    override val scores: Map<WvwObjectiveOwner, Int>,

    /**
     * The score within the [WvwSkirmish.mapScores] for each [WvwMapType] and [WvwObjectiveOwner].
     */
    val mapScores: Map<WvwMapType, Map<WvwObjectiveOwner, Int>>
) : ObjectiveOwnerScore {
    constructor() : this(
        emptyMap(),
        emptyMap()
    )

    @Suppress("UNCHECKED_CAST")
    constructor(skirmish: WvwSkirmish) : this(
        scores = skirmish.scores.count(),
        mapScores = skirmish.mapScores.associate { scores ->
            scores.mapType.decodeOrNull() to scores.scores.count()
        }.filterKeys { type ->
            type != null
        } as Map<WvwMapType, Map<WvwObjectiveOwner, Int>>
    )
}