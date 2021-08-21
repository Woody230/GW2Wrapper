package com.bselzer.library.gw2.v2.model.enumeration.common.extension.skill

import com.bselzer.library.gw2.v2.model.common.skill.fact.ComboFieldFact
import com.bselzer.library.gw2.v2.model.enumeration.common.skill.ComboFieldType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [ComboFieldFact.fieldType] as a [ComboFieldType]
 */
fun ComboFieldFact.fieldType(): ComboFieldType? = fieldType.enumValueOrNull<ComboFieldType>()