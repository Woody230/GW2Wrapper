package com.bselzer.library.gw2.v2.model.enumeration.extension.skill

import com.bselzer.library.gw2.v2.model.enumeration.skill.ComboFieldType
import com.bselzer.library.gw2.v2.model.skill.fact.SkillComboFieldFact
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [SkillComboFieldFact.fieldType] as a [ComboFieldType]
 */
fun SkillComboFieldFact.fieldType(): ComboFieldType? = fieldType.enumValueOrNull<ComboFieldType>()