package com.bselzer.library.gw2.v2.model.enumeration.extension.trait

import com.bselzer.library.gw2.v2.model.enumeration.skill.ComboFinisherType
import com.bselzer.library.gw2.v2.model.trait.fact.TraitComboFinisherFact
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [TraitComboFinisherFact.finisherType] as a [ComboFinisherType]
 */
fun TraitComboFinisherFact.finisherType(): ComboFinisherType? = finisherType.enumValueOrNull<ComboFinisherType>()