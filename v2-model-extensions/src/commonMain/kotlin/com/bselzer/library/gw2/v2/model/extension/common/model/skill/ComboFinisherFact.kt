package com.bselzer.library.gw2.v2.model.extension.common.model.skill

import com.bselzer.library.gw2.v2.model.common.skill.fact.ComboFinisherFact
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.ComboFinisherType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [ComboFinisherFact.finisherType] as a [ComboFinisherType]
 */
fun ComboFinisherFact.finisherType(): ComboFinisherType? = finisherType.enumValueOrNull<ComboFinisherType>()