package com.bselzer.library.gw2.v2.model.extension.common.model.itemstat

import com.bselzer.library.gw2.v2.model.common.character.ItemStat
import com.bselzer.library.gw2.v2.model.common.itemstat.ItemAttribute
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.AttributeName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

/**
 * The [ItemAttribute.name] as an [AttributeName]
 */
fun ItemAttribute.name(): AttributeName? = name.enumValueOrNull<AttributeName>()

/**
 * The [ItemStat.attributes] with [AttributeName] keys
 */
fun ItemStat.attributes(): Map<AttributeName, Double> = attributes.validEnumValues()