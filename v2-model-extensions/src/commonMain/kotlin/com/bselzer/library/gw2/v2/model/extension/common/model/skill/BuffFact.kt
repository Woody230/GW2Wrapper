package com.bselzer.library.gw2.v2.model.extension.common.model.skill

import com.bselzer.library.gw2.v2.model.common.skill.fact.BuffFact
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.EffectName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [BuffFact.status] as an [EffectName]
 */
fun BuffFact.status(): EffectName? = status.enumValueOrNull<EffectName>()