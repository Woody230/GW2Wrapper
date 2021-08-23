package com.bselzer.library.gw2.v2.model.enumeration.extension.skill

import com.bselzer.library.gw2.v2.model.enumeration.skill.EffectName
import com.bselzer.library.gw2.v2.model.skill.fact.PrefixedBuffFact
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [PrefixedBuffFact.status] as an [EffectName]
 */
fun PrefixedBuffFact.status(): EffectName? = status.enumValueOrNull<EffectName>()