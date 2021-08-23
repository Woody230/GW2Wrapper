package com.bselzer.library.gw2.v2.model.enumeration.extension.trait

import com.bselzer.library.gw2.v2.model.enumeration.trait.TraitSlot
import com.bselzer.library.gw2.v2.model.enumeration.trait.TraitTier
import com.bselzer.library.gw2.v2.model.trait.Trait
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [Trait.tier] as a [TraitTier]
 */
fun Trait.tier(): TraitTier? = tier.toString().enumValueOrNull<TraitTier>()

/**
 * The [Trait.slot] as a [TraitSlot]
 */
fun Trait.slot(): TraitSlot? = slot.enumValueOrNull<TraitSlot>()