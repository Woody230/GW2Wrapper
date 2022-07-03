package com.bselzer.gw2.v2.model.extension.wvw.count

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea.ContestedAreas
import com.bselzer.gw2.v2.model.wvw.map.WvwMap

class WvwMapObjectiveOwnerCount internal constructor(
    /**
     * The points that would currently be awarded to each [WvwObjectiveOwner] if a tick passed
     */
    override val pointsPerTick: Map<WvwObjectiveOwner, Int>,

    /**
     * The score within the [WvwMap.scores] for each [WvwObjectiveOwner]
     */
    override val scores: Map<WvwObjectiveOwner, Int>,

    /**
     * The deaths within the [WvwMap.deaths] for each [WvwObjectiveOwner]
     */
    override val deaths: Map<WvwObjectiveOwner, Int>,

    /**
     * The kills within the [WvwMap.kills] for each [WvwObjectiveOwner]
     */
    override val kills: Map<WvwObjectiveOwner, Int>,

    /**
     * The objectives collected based on their owner and type.
     */
    override val contestedAreas: ContestedAreas,
) : ObjectiveOwnerCount {
    constructor() : this(
        emptyMap(),
        emptyMap(),
        emptyMap(),
        emptyMap(),
        ContestedAreas()
    )

    constructor(map: WvwMap) : this(
        pointsPerTick = map.objectives.pointsPerTick(),
        scores = map.scores.count(),
        deaths = map.deaths.count(),
        kills = map.kills.count(),
        contestedAreas = ContestedAreas(map.objectives),
    )
}