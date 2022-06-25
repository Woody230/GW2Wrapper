package com.bselzer.gw2.v2.model.extension.wvw.count

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea.ContestedAreas
import com.bselzer.gw2.v2.model.extension.wvw.mapObjectives
import com.bselzer.gw2.v2.model.wvw.match.WvwMatch

data class WvwMatchObjectiveOwnerCount internal constructor(
    /**
     * The points that would currently be awarded to each [WvwObjectiveOwner] if a tick passed
     */
    override val pointsPerTick: Map<WvwObjectiveOwner, Int>,

    /**
     * The score within the [WvwMatch.scores] for each [WvwObjectiveOwner]
     */
    override val scores: Map<WvwObjectiveOwner, Int>,

    /**
     * The deaths within the [WvwMatch.deaths] for each [WvwObjectiveOwner]
     */
    override val deaths: Map<WvwObjectiveOwner, Int>,

    /**
     * The kills within the [WvwMatch.kills] for each [WvwObjectiveOwner]
     */
    override val kills: Map<WvwObjectiveOwner, Int>,

    /**
     * The objectives collected based on their owner and type.
     */
    override val contestedAreas: ContestedAreas,

    /**
     * The total number of victory points earned through all of the skirmishes for each [WvwObjectiveOwner]
     */
    val victoryPoints: Map<WvwObjectiveOwner, Int>,
) : ObjectiveOwnerCount {
    constructor(match: WvwMatch) : this(
        pointsPerTick = match.mapObjectives().pointsPerTick(),
        scores = match.scores.count(),
        deaths = match.deaths.count(),
        kills = match.kills.count(),
        contestedAreas = ContestedAreas(match.mapObjectives()),
        victoryPoints = match.victoryPoints.count(),
    )
}