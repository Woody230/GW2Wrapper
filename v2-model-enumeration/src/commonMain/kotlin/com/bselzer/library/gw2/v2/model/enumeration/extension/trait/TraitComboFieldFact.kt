package com.bselzer.library.gw2.v2.model.enumeration.extension.trait

import com.bselzer.library.gw2.v2.model.enumeration.skill.ComboFieldType
import com.bselzer.library.gw2.v2.model.trait.fact.TraitComboFieldFact
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [TraitComboFieldFact.fieldType] as a [ComboFieldType]
 */
fun TraitComboFieldFact.fieldType(): ComboFieldType? = fieldType.enumValueOrNull<ComboFieldType>()