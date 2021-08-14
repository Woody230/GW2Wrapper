package com.bselzer.library.gw2.v2.model.extension.common.model.itemstat

import com.bselzer.library.gw2.v2.model.common.itemstat.ItemAttribute
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.AttributeName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [ItemAttribute.name] as an [AttributeName]
 */
fun ItemAttribute.name(): AttributeName? = name.enumValueOrNull<AttributeName>()