package com.bselzer.library.gw2.v2.model.enumeration.common.extension.skin

import com.bselzer.library.gw2.v2.model.common.skin.Skin
import com.bselzer.library.gw2.v2.model.enumeration.common.character.RaceName
import com.bselzer.library.gw2.v2.model.enumeration.common.item.ItemRarity
import com.bselzer.library.gw2.v2.model.enumeration.common.skin.SkinFlag
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

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