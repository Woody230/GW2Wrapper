package com.bselzer.library.gw2.v2.model.enumeration.common.extension.item

import com.bselzer.library.gw2.v2.model.common.item.Item
import com.bselzer.library.gw2.v2.model.enumeration.common.item.ItemFlag
import com.bselzer.library.gw2.v2.model.enumeration.common.item.ItemGameType
import com.bselzer.library.gw2.v2.model.enumeration.common.item.ItemRarity
import com.bselzer.library.gw2.v2.model.enumeration.common.item.ItemRestriction
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [Item.rarity] as an [ItemRarity]
 */
fun Item.rarity(): ItemRarity? = rarity.enumValueOrNull<ItemRarity>()

/**
 * The [Item.flags] as a collection of [ItemFlag]
 */
fun Item.flags(): List<ItemFlag> = flags.validEnumValues()

/**
 * The [Item.gameTypes] as a collection of [ItemGameType]
 */
fun Item.gameTypes(): List<ItemGameType> = gameTypes.validEnumValues()

/**
 * The [Item.restrictions] as a collection of [ItemRestriction]
 */
fun Item.restrictions(): List<ItemRestriction> = restrictions.validEnumValues()