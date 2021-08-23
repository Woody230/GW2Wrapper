package com.bselzer.library.gw2.v2.model.enumeration.extension.novelty

import com.bselzer.library.gw2.v2.model.enumeration.novelty.NoveltySlot
import com.bselzer.library.gw2.v2.model.novelty.Novelty
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [Novelty.slot] as a [NoveltySlot]
 */
fun Novelty.slot(): NoveltySlot? = slot.enumValueOrNull<NoveltySlot>()