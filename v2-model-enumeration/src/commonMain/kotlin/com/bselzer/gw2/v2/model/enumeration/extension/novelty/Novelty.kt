package com.bselzer.gw2.v2.model.enumeration.extension.novelty

import com.bselzer.gw2.v2.model.enumeration.novelty.NoveltySlot
import com.bselzer.gw2.v2.model.novelty.Novelty
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [Novelty.slot] as a [NoveltySlot]
 */
fun Novelty.slot(): NoveltySlot? = slot.enumValueOrNull<NoveltySlot>()