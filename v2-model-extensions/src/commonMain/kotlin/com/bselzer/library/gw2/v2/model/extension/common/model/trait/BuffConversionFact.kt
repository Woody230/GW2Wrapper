package com.bselzer.library.gw2.v2.model.extension.common.model.trait

import com.bselzer.library.gw2.v2.model.common.trait.fact.BuffConversionFact
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.AttributeName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [BuffConversionFact.source] as an [AttributeName]
 */
fun BuffConversionFact.source(): AttributeName? = source.enumValueOrNull<AttributeName>()

/**
 * The [BuffConversionFact.target] as an [AttributeName]
 */
fun BuffConversionFact.target(): AttributeName? = target.enumValueOrNull<AttributeName>()