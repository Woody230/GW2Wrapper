package com.bselzer.library.gw2.v2.model.enumeration.extension.skill

import com.bselzer.library.gw2.v2.model.enumeration.skill.EffectName
import com.bselzer.library.gw2.v2.model.skill.fact.SkillBuffFact
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [SkillBuffFact.status] as an [EffectName]
 */
fun SkillBuffFact.status(): EffectName? = status.enumValueOrNull<EffectName>()