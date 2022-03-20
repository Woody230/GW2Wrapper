package com.bselzer.gw2.v2.model.extension.wvw

import com.bselzer.gw2.v2.model.enumeration.wvw.ObjectiveOwner
import com.bselzer.gw2.v2.model.wvw.world.WvwWorldCount

/**
 * @return a mapping of the owner to the [WvwWorldCount] value
 */
internal fun WvwWorldCount.count(): Map<ObjectiveOwner, Int> = mapOf(
    ObjectiveOwner.BLUE to blue,
    ObjectiveOwner.GREEN to green,
    ObjectiveOwner.RED to red
)

/**
 * Sums the values in the given [data] with the receiving data values.
 */
internal fun MutableMap<ObjectiveOwner?, Int>.merge(data: Map<ObjectiveOwner?, Int>) = data.forEach { entry ->
    val owner = entry.key
    this[owner] = this.getOrElse(owner) { 0 }.plus(entry.value)
}