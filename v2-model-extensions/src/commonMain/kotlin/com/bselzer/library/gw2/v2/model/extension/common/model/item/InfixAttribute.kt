package com.bselzer.library.gw2.v2.model.extension.common.model.item

import com.bselzer.library.gw2.v2.model.common.item.detail.infix.InfixAttribute
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.AttributeName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [InfixAttribute.attribute] as an [AttributeName]
 */
fun InfixAttribute.attribute(): AttributeName? = attribute.enumValueOrNull<AttributeName>()