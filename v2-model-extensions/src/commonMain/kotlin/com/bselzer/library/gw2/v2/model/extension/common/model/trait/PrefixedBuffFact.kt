package com.bselzer.library.gw2.v2.model.extension.common.model.trait

import com.bselzer.library.gw2.v2.model.common.trait.fact.PrefixedBuffFact
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.EffectName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [PrefixedBuffFact.status] as an [EffectName]
 */
fun PrefixedBuffFact.status(): EffectName? = status.enumValueOrNull<EffectName>()