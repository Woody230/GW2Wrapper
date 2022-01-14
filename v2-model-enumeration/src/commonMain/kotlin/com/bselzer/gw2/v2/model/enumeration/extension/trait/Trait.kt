package com.bselzer.gw2.v2.model.enumeration.extension.trait

import com.bselzer.gw2.v2.model.enumeration.trait.TraitSlot
import com.bselzer.gw2.v2.model.enumeration.trait.TraitTier
import com.bselzer.gw2.v2.model.trait.Trait
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [Trait.tier] as a [TraitTier]
 */
fun Trait.tier(): TraitTier? = tier.toString().enumValueOrNull<TraitTier>()

/**
 * The [Trait.slot] as a [TraitSlot]
 */
fun Trait.slot(): TraitSlot? = slot.enumValueOrNull<TraitSlot>()