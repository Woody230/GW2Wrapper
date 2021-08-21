package com.bselzer.library.gw2.v2.model.enumeration.common.extension.skill

import com.bselzer.library.gw2.v2.model.common.skill.fact.ComboFinisherFact
import com.bselzer.library.gw2.v2.model.enumeration.common.skill.ComboFinisherType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [ComboFinisherFact.finisherType] as a [ComboFinisherType]
 */
fun ComboFinisherFact.finisherType(): ComboFinisherType? = finisherType.enumValueOrNull<ComboFinisherType>()