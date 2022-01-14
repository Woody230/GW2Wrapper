package com.bselzer.gw2.v2.model.enumeration.extension.trait

import com.bselzer.gw2.v2.model.enumeration.skill.ComboFieldType
import com.bselzer.gw2.v2.model.trait.fact.TraitComboFieldFact
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [TraitComboFieldFact.fieldType] as a [ComboFieldType]
 */
fun TraitComboFieldFact.fieldType(): ComboFieldType? = fieldType.enumValueOrNull<ComboFieldType>()