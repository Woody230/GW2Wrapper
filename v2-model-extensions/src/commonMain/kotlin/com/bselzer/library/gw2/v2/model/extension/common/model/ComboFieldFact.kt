package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.skill.fact.ComboFieldFact
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skill.ComboFieldType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [ComboFieldFact.fieldType] as a [ComboFieldType]
 */
fun ComboFieldFact.fieldType(): ComboFieldType? = fieldType.enumValueOrNull<ComboFieldType>()