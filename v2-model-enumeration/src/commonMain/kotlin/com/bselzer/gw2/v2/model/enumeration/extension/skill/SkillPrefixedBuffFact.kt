package com.bselzer.gw2.v2.model.enumeration.extension.skill

import com.bselzer.gw2.v2.model.enumeration.skill.EffectName
import com.bselzer.gw2.v2.model.skill.fact.SkillPrefixedBuffFact
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [SkillPrefixedBuffFact.status] as an [EffectName]
 */
fun SkillPrefixedBuffFact.status(): EffectName? = status.enumValueOrNull<EffectName>()