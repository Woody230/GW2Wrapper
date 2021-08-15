package com.bselzer.library.gw2.v2.model.extension.common.model.novelty

import com.bselzer.library.gw2.v2.model.common.novelty.Novelty
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.novelty.NoveltySlot
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [Novelty.slot] as a [NoveltySlot]
 */
fun Novelty.slot(): NoveltySlot? = slot.enumValueOrNull<NoveltySlot>()