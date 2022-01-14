package com.bselzer.gw2.v2.model.enumeration.extension.skill

import com.bselzer.gw2.v2.model.enumeration.skill.ComboFieldType
import com.bselzer.gw2.v2.model.skill.fact.SkillComboFieldFact
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [SkillComboFieldFact.fieldType] as a [ComboFieldType]
 */
fun SkillComboFieldFact.fieldType(): ComboFieldType? = fieldType.enumValueOrNull<ComboFieldType>()