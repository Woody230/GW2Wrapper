package com.bselzer.gw2.v2.model.enumeration.extension.skin

import com.bselzer.gw2.v2.model.enumeration.character.RaceName
import com.bselzer.gw2.v2.model.enumeration.item.ItemRarity
import com.bselzer.gw2.v2.model.enumeration.skin.SkinFlag
import com.bselzer.gw2.v2.model.skin.Skin
import com.bselzer.ktx.serialization.function.enumValueOrNull
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [Skin.flags] as a collection of [SkinFlag]
 */
fun Skin.flags(): List<SkinFlag> = flags.validEnumValues()

/**
 * The [Skin.restrictions] as a collection of [RaceName]
 */
fun Skin.restrictions(): List<RaceName> = flags.validEnumValues()

/**
 * The [Skin.rarity] as an [ItemRarity]
 */
fun Skin.rarity(): ItemRarity? = rarity.enumValueOrNull<ItemRarity>()