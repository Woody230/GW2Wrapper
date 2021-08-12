package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.skill.fact.AttributeAdjustFact
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.AttributeName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [AttributeAdjustFact.target] as an [AttributeName]
 */
fun AttributeAdjustFact.target(): AttributeName? = target.enumValueOrNull<AttributeName>()