package com.bselzer.library.gw2.v2.model.extension.common.model.trait

import com.bselzer.library.gw2.v2.model.common.trait.fact.BuffFact
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.EffectName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [BuffFact.status] as an [EffectName]
 */
fun BuffFact.status(): EffectName? = status.enumValueOrNull<EffectName>()