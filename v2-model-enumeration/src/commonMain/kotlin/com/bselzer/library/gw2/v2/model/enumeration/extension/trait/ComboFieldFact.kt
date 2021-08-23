package com.bselzer.library.gw2.v2.model.enumeration.extension.trait

import com.bselzer.library.gw2.v2.model.enumeration.skill.ComboFieldType
import com.bselzer.library.gw2.v2.model.trait.fact.ComboFieldFact
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [ComboFieldFact.fieldType] as a [ComboFieldType]
 */
fun ComboFieldFact.fieldType(): ComboFieldType? = fieldType.enumValueOrNull<ComboFieldType>()