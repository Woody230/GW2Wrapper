package com.bselzer.gw2.v2.model.enumeration.extension.trait

import com.bselzer.gw2.v2.model.enumeration.skill.EffectName
import com.bselzer.gw2.v2.model.trait.fact.TraitPrefixedBuffFact
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [TraitPrefixedBuffFact.status] as an [EffectName]
 */
fun TraitPrefixedBuffFact.status(): EffectName? = status.enumValueOrNull<EffectName>()