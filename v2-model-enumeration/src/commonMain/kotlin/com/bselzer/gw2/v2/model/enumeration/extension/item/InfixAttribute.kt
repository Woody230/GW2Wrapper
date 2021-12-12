package com.bselzer.gw2.v2.model.enumeration.extension.item

import com.bselzer.gw2.v2.model.enumeration.profession.AttributeName
import com.bselzer.gw2.v2.model.item.detail.infix.InfixAttribute
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [InfixAttribute.attribute] as an [AttributeName]
 */
fun InfixAttribute.attribute(): AttributeName? = attribute.enumValueOrNull<AttributeName>()