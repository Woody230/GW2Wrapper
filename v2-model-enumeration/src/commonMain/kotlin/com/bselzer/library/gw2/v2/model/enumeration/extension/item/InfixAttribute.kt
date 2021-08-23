package com.bselzer.library.gw2.v2.model.enumeration.extension.item

import com.bselzer.library.gw2.v2.model.enumeration.profession.AttributeName
import com.bselzer.library.gw2.v2.model.item.detail.infix.InfixAttribute
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [InfixAttribute.attribute] as an [AttributeName]
 */
fun InfixAttribute.attribute(): AttributeName? = attribute.enumValueOrNull<AttributeName>()