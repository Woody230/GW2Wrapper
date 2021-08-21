package com.bselzer.library.gw2.v2.model.enumeration.common.extension.novelty

import com.bselzer.library.gw2.v2.model.common.novelty.Novelty
import com.bselzer.library.gw2.v2.model.enumeration.common.novelty.NoveltySlot
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [Novelty.slot] as a [NoveltySlot]
 */
fun Novelty.slot(): NoveltySlot? = slot.enumValueOrNull<NoveltySlot>()