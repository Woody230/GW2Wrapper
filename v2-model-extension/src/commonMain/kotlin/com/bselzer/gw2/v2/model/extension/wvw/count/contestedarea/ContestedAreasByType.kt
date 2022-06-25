package com.bselzer.gw2.v2.model.extension.wvw.count.contestedarea

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective

/**
 * Represents the contested areas by a grid of counts where the x-axis is the [WvwObjectiveOwner] and y-axis is the [WvwObjectiveType].
 */
class ContestedAreasByType(objectives: Collection<WvwMapObjective>) : ContestedAreasGrid(objectives) {
    /**
     * A two-dimensional list of counts where the outer list represents the counts per [WvwObjectiveType] and the inner list represents the counts per [WvwObjectiveOwner].
     */
    override val counts: List<List<ContestedAreasCount>> = WVW_OBJECTIVE_TYPES.map { type ->
        WVW_OBJECTIVE_OWNERS.map { owner -> createCount(owner, type) }
    }

    /**
     * Finds the [ContestedAreasCount] for the given [owner] and [type].
     */
    fun find(type: WvwObjectiveType, owner: WvwObjectiveOwner): ContestedAreasCount = counts[type.ordinal][owner.ordinal]

    /**
     * Finds the [ContestedAreasCount]s for all [WvwObjectiveOwner]s and the given [types].
     */
    fun filter(vararg types: WvwObjectiveType): List<List<ContestedAreasCount>> = filter(types.toList(), WVW_OBJECTIVE_OWNERS)

    /**
     * Finds the [ContestedAreasCount]s for the given [owners] and for all [WvwObjectiveType]s.
     */
    fun filter(vararg owners: WvwObjectiveOwner): List<List<ContestedAreasCount>> = filter(WVW_OBJECTIVE_TYPES, owners.toList())

    /**
     * Finds the [ContestedAreasCount]s for the given [type] and [owners].
     */
    fun filter(type: WvwObjectiveType, vararg owners: WvwObjectiveOwner) = filter(listOf(type), owners.toList()).first()

    /**
     * Finds the [ContestedAreasCount]s for the given [owners] and [types].
     */
    fun filter(types: Collection<WvwObjectiveType>, owners: Collection<WvwObjectiveOwner>): List<List<ContestedAreasCount>> = types.map { type ->
        owners.map { owner -> find(type, owner) }
    }
}