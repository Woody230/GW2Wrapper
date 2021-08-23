package com.bselzer.library.gw2.v2.model.enumeration.extension.itemstat

import com.bselzer.library.gw2.v2.model.character.CharacterItemStat
import com.bselzer.library.gw2.v2.model.enumeration.profession.AttributeName
import com.bselzer.library.gw2.v2.model.itemstat.ItemAttribute
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull
import com.bselzer.library.kotlin.extension.serialization.function.validEnumValues

/**
 * The [ItemAttribute.name] as an [AttributeName]
 */
fun ItemAttribute.name(): AttributeName? = name.enumValueOrNull<AttributeName>()

/**
 * The [CharacterItemStat.attributes] with [AttributeName] keys
 */
fun CharacterItemStat.attributes(): Map<AttributeName, Double> = attributes.validEnumValues()