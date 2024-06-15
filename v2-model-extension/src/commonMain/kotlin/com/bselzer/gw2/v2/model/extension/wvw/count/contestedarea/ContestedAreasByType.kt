package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective

/**
 * Represents the contested areas by a grid of counts where the x-axis is the [WvwObjectiveOwner] and y-axis is the [WvwObjectiveType].
 */
class ContestedAreasByType internal constructor(
    private val objectives: Map<WvwObjectiveType, Map<WvwObjectiveOwner, Collection<WvwMapObjective>>>
) {
    /**
     * Finds the [ContestedAreasCount] for the given [owner] and [type].
     */
    fun get(type: WvwObjectiveType, owner: WvwObjectiveOwner): ContestedAreasCount = ContestedAreasCount(
        owner = owner,
        type = type,
        objectives = objectives[type]?.get(owner) ?: emptyList()
    )

    /**
     * Finds the [ContestedAreasCount]s for all [WvwObjectiveOwner]s and the given [types].
     */
    fun filter(vararg types: WvwObjectiveType): List<ContestedAreasCountByType> = filter(types.toList(), WvwObjectiveOwner.entries.toList())

    /**
     * Finds the [ContestedAreasCount]s for the given [owners] and for all [WvwObjectiveType]s.
     */
    fun filter(vararg owners: WvwObjectiveOwner): List<ContestedAreasCountByType> = filter(WvwObjectiveType.entries.toList(), owners.toList())

    /**
     * Finds the [ContestedAreasCount]s for the given [type] and [owners].
     */
    fun filter(type: WvwObjectiveType, vararg owners: WvwObjectiveOwner): ContestedAreasCountByType = filter(listOf(type), owners.toList()).first()

    /**
     * Finds the [ContestedAreasCount]s for the given [owners] and [types].
     */
    fun filter(types: Collection<WvwObjectiveType>, owners: Collection<WvwObjectiveOwner>): List<ContestedAreasCountByType> = types.map { type ->
        ContestedAreasCountByType(
            type = type,
            counts = owners.map { owner -> get(type, owner) }
        )
    }
}