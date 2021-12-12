package com.bselzer.gw2.v2.model.enumeration.extension.itemstat

import com.bselzer.gw2.v2.model.character.CharacterItemStat
import com.bselzer.gw2.v2.model.enumeration.profession.AttributeName
import com.bselzer.gw2.v2.model.itemstat.ItemAttribute
import com.bselzer.ktx.serialization.function.enumValueOrNull
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [ItemAttribute.name] as an [AttributeName]
 */
fun ItemAttribute.name(): AttributeName? = name.enumValueOrNull<AttributeName>()

/**
 * The [CharacterItemStat.attributes] with [AttributeName] keys
 */
fun CharacterItemStat.attributes(): Map<AttributeName, Double> = attributes.validEnumValues()