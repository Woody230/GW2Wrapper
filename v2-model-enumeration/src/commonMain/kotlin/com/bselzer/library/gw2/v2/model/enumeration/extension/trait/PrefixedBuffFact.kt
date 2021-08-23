package com.bselzer.library.gw2.v2.model.enumeration.extension.trait

import com.bselzer.library.gw2.v2.model.enumeration.skill.EffectName
import com.bselzer.library.gw2.v2.model.trait.fact.PrefixedBuffFact
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [PrefixedBuffFact.status] as an [EffectName]
 */
fun PrefixedBuffFact.status(): EffectName? = status.enumValueOrNull<EffectName>()