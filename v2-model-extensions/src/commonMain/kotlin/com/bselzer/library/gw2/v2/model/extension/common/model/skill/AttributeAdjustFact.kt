package com.bselzer.library.gw2.v2.model.extension.common.model.skill

import com.bselzer.library.gw2.v2.model.common.skill.fact.AttributeAdjustFact
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.AttributeName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [AttributeAdjustFact.target] as an [AttributeName]
 */
fun AttributeAdjustFact.target(): AttributeName? = target.enumValueOrNull<AttributeName>()