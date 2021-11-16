package com.bselzer.library.gw2.v2.model.enumeration.extension.skill

import com.bselzer.library.gw2.v2.model.enumeration.profession.AttributeName
import com.bselzer.library.gw2.v2.model.skill.fact.SkillAttributeAdjustFact
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [SkillAttributeAdjustFact.target] as an [AttributeName]
 */
fun SkillAttributeAdjustFact.target(): AttributeName? = target.enumValueOrNull<AttributeName>()