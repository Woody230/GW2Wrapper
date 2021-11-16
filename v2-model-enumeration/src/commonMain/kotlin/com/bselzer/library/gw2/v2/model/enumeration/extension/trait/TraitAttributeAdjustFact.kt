package com.bselzer.library.gw2.v2.model.enumeration.extension.trait

import com.bselzer.library.gw2.v2.model.enumeration.profession.AttributeName
import com.bselzer.library.gw2.v2.model.trait.fact.TraitAttributeAdjustFact
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [TraitAttributeAdjustFact.target] as an [AttributeName]
 */
fun TraitAttributeAdjustFact.target(): AttributeName? = target.enumValueOrNull<AttributeName>()