package com.bselzer.gw2.v2.model.enumeration.extension.trait

import com.bselzer.gw2.v2.model.enumeration.profession.AttributeName
import com.bselzer.gw2.v2.model.trait.fact.TraitBuffConversionFact
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [TraitBuffConversionFact.source] as an [AttributeName]
 */
fun TraitBuffConversionFact.source(): AttributeName? = source.enumValueOrNull<AttributeName>()

/**
 * The [TraitBuffConversionFact.target] as an [AttributeName]
 */
fun TraitBuffConversionFact.target(): AttributeName? = target.enumValueOrNull<AttributeName>()