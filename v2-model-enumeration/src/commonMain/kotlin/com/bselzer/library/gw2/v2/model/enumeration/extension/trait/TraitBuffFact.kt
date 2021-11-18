package com.bselzer.library.gw2.v2.model.enumeration.extension.trait

import com.bselzer.library.gw2.v2.model.enumeration.skill.EffectName
import com.bselzer.library.gw2.v2.model.trait.fact.TraitBuffFact
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [TraitBuffFact.status] as an [EffectName]
 */
fun TraitBuffFact.status(): EffectName? = status.enumValueOrNull<EffectName>()