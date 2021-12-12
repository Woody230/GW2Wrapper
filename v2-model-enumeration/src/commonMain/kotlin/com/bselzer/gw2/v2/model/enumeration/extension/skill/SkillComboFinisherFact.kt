package com.bselzer.gw2.v2.model.enumeration.extension.skill

import com.bselzer.gw2.v2.model.enumeration.skill.ComboFinisherType
import com.bselzer.gw2.v2.model.skill.fact.SkillComboFinisherFact
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [SkillComboFinisherFact.finisherType] as a [ComboFinisherType]
 */
fun SkillComboFinisherFact.finisherType(): ComboFinisherType? = finisherType.enumValueOrNull<ComboFinisherType>()