package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective

/**
 * Represents the contested areas by a grid of counts where the x-axis is the [WvwObjectiveType] and y-axis is the [WvwObjectiveOwner].
 */
class ContestedAreasByOwner internal constructor(
    private val objectives: Map<WvwObjectiveOwner, Map<WvwObjectiveType, Collection<WvwMapObjective>>>
) {
    /**
     * Finds the [ContestedAreasCount] for the given [owner] and [type].
     */
    fun get(owner: WvwObjectiveOwner, type: WvwObjectiveType): ContestedAreasCount = ContestedAreasCount(
        owner = owner,
        type = type,
        objectives = objectives[owner]?.get(type) ?: emptyList()
    )

    /**
     * Finds the [ContestedAreasCount]s for all [WvwObjectiveOwner]s and the given [types].
     */
    fun filter(vararg types: WvwObjectiveType): List<ContestedAreasCountByOwner> = filter(WvwObjectiveOwner.values().toList(), types.toList())

    /**
     * Finds the [ContestedAreasCount]s for the given [owners] and for all [WvwObjectiveType]s.
     */
    fun filter(vararg owners: WvwObjectiveOwner): List<ContestedAreasCountByOwner> = filter(owners.toList(), WvwObjectiveType.values().toList())

    /**
     * Finds the [ContestedAreasCount]s for the given [owner] and [types].
     */
    fun filter(owner: WvwObjectiveOwner, vararg types: WvwObjectiveType): ContestedAreasCountByOwner = filter(listOf(owner), types.toList()).first()

    /**
     * Finds the [ContestedAreasCount]s for the given [owners] and [types].
     */
    fun filter(owners: Collection<WvwObjectiveOwner>, types: Collection<WvwObjectiveType>): List<ContestedAreasCountByOwner> = owners.map { owner ->
        ContestedAreasCountByOwner(
            owner = owner,
            counts = types.map { type -> get(owner, type) }
        )
    }
}