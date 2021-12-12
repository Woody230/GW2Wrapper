package com.bselzer.gw2.v2.model.enumeration.extension.skill

import com.bselzer.gw2.v2.model.enumeration.skill.EffectName
import com.bselzer.gw2.v2.model.skill.fact.SkillBuffFact
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [SkillBuffFact.status] as an [EffectName]
 */
fun SkillBuffFact.status(): EffectName? = status.enumValueOrNull<EffectName>()