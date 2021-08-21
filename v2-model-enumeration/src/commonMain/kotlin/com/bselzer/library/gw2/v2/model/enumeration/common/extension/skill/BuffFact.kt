package com.bselzer.library.gw2.v2.model.enumeration.common.extension.skill

import com.bselzer.library.gw2.v2.model.common.skill.fact.BuffFact
import com.bselzer.library.gw2.v2.model.enumeration.common.skill.EffectName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [BuffFact.status] as an [EffectName]
 */
fun BuffFact.status(): EffectName? = status.enumValueOrNull<EffectName>()