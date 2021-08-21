package com.bselzer.library.gw2.v2.model.enumeration.common.extension.trait

import com.bselzer.library.gw2.v2.model.common.trait.fact.BuffConversionFact
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.AttributeName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [BuffConversionFact.source] as an [AttributeName]
 */
fun BuffConversionFact.source(): AttributeName? = source.enumValueOrNull<AttributeName>()

/**
 * The [BuffConversionFact.target] as an [AttributeName]
 */
fun BuffConversionFact.target(): AttributeName? = target.enumValueOrNull<AttributeName>()