package com.bselzer.library.gw2.v2.model.enumeration.extension.skill

import com.bselzer.library.gw2.v2.model.enumeration.skill.EffectName
import com.bselzer.library.gw2.v2.model.skill.fact.BuffFact
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [BuffFact.status] as an [EffectName]
 */
fun BuffFact.status(): EffectName? = status.enumValueOrNull<EffectName>()