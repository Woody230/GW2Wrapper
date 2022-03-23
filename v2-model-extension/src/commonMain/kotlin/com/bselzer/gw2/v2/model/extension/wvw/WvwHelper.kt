package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldCount

/**
 * @return a mapping of the owner to the [WvwWorldCount] value
 */
internal fun WvwWorldCount.count(): Map<WvwObjectiveOwner, Int> = mapOf(
    WvwObjectiveOwner.BLUE to blue,
    WvwObjectiveOwner.GREEN to green,
    WvwObjectiveOwner.RED to red
)

/**
 * Sums the values in the given [data] with the receiving data values.
 */
internal fun MutableMap<WvwObjectiveOwner?, Int>.merge(data: Map<WvwObjectiveOwner?, Int>) = data.forEach { entry ->
    val owner = entry.key
    this[owner] = this.getOrElse(owner) { 0 }.plus(entry.value)
}