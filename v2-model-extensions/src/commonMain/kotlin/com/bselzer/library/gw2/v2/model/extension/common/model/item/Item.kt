package com.bselzer.library.gw2.v2.model.extension.common.model.item

import com.bselzer.library.gw2.v2.model.common.item.Item
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.ItemFlag
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.ItemGameType
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.ItemRarity
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.ItemRestriction
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