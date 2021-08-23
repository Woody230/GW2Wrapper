package com.bselzer.library.gw2.v2.model.enumeration.extension.skill

import com.bselzer.library.gw2.v2.model.enumeration.skill.ComboFinisherType
import com.bselzer.library.gw2.v2.model.skill.fact.ComboFinisherFact
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [ComboFinisherFact.finisherType] as a [ComboFinisherType]
 */
fun ComboFinisherFact.finisherType(): ComboFinisherType? = finisherType.enumValueOrNull<ComboFinisherType>()