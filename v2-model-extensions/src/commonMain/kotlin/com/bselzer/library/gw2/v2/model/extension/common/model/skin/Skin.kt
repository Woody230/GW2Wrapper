package com.bselzer.library.gw2.v2.model.extension.common.model.skin

import com.bselzer.library.gw2.v2.model.common.skin.Skin
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.character.RaceName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.ItemRarity
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skin.SkinFlag
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

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