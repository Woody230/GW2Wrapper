package com.bselzer.library.gw2.v2.model.extension.common.model.trait

import com.bselzer.library.gw2.v2.model.common.trait.fact.ComboFieldFact
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.ComboFieldType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [ComboFieldFact.fieldType] as a [ComboFieldType]
 */
fun ComboFieldFact.fieldType(): ComboFieldType? = fieldType.enumValueOrNull<ComboFieldType>()