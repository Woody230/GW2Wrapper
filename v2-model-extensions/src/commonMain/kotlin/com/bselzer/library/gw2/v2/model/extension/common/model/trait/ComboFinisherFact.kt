package com.bselzer.library.gw2.v2.model.extension.common.model.trait

import com.bselzer.library.gw2.v2.model.common.trait.fact.ComboFinisherFact
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.ComboFinisherType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [ComboFinisherFact.finisherType] as a [ComboFinisherType]
 */
fun ComboFinisherFact.finisherType(): ComboFinisherType? = finisherType.enumValueOrNull<ComboFinisherType>()