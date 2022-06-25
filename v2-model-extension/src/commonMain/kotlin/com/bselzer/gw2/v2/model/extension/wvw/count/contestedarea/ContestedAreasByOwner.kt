package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective

/**
 * Represents the contested areas by a grid of counts where the x-axis is the [WvwObjectiveType] and y-axis is the [WvwObjectiveOwner].
 *
 * The [counts] is a two-dimensional list of counts where the outer list represents the counts per [WvwObjectiveOwner]
 * and the inner list represents the counts per [WvwObjectiveType].
 */
class ContestedAreasByOwner(objectives: Collection<WvwMapObjective>) : ContestedAreasGrid(objectives.contestedAreas()) {
    private companion object {
        fun Collection<WvwMapObjective>.contestedAreas() = WVW_OBJECTIVE_OWNERS.map { owner ->
            WVW_OBJECTIVE_TYPES.map { type -> createCount(owner, type) }
        }
    }

    /**
     * Finds the [ContestedAreasCount] for the given [owner] and [type].
     */
    fun find(owner: WvwObjectiveOwner, type: WvwObjectiveType): ContestedAreasCount = counts[owner.ordinal][type.ordinal]

    /**
     * Finds the [ContestedAreasCount]s for all [WvwObjectiveOwner]s and the given [types].
     */
    fun filter(vararg types: WvwObjectiveType): List<ContestedAreasCountByOwner> = filter(WVW_OBJECTIVE_OWNERS, types.toList())

    /**
     * Finds the [ContestedAreasCount]s for the given [owners] and for all [WvwObjectiveType]s.
     */
    fun filter(vararg owners: WvwObjectiveOwner): List<ContestedAreasCountByOwner> = filter(owners.toList(), WVW_OBJECTIVE_TYPES)

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
            counts = types.map { type -> find(owner, type) }
        )
    }
}