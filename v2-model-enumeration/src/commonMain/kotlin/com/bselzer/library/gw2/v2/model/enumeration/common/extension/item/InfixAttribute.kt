package com.bselzer.library.gw2.v2.model.enumeration.common.extension.item

import com.bselzer.library.gw2.v2.model.common.item.detail.infix.InfixAttribute
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.AttributeName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [InfixAttribute.attribute] as an [AttributeName]
 */
fun InfixAttribute.attribute(): AttributeName? = attribute.enumValueOrNull<AttributeName>()