package com.bselzer.library.gw2.v2.model.enumeration.common.extension.itemstat

import com.bselzer.library.gw2.v2.model.common.character.CharacterItemStat
import com.bselzer.library.gw2.v2.model.common.itemstat.ItemAttribute
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.AttributeName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [ItemAttribute.name] as an [AttributeName]
 */
fun ItemAttribute.name(): AttributeName? = name.enumValueOrNull<AttributeName>()

/**
 * The [CharacterItemStat.attributes] with [AttributeName] keys
 */
fun CharacterItemStat.attributes(): Map<AttributeName, Double> = attributes.validEnumValues()