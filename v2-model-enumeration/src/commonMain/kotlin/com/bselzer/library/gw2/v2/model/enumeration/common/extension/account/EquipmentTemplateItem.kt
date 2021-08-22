package com.bselzer.library.gw2.v2.model.enumeration.common.extension.account

import com.bselzer.library.gw2.v2.model.common.account.equipment.EquipmentTemplateItem
import com.bselzer.library.gw2.v2.model.enumeration.common.character.EquipmentSlot
import com.bselzer.library.gw2.v2.model.enumeration.common.item.ItemLocation
import com.bselzer.library.gw2.v2.model.enumeration.common.scope.Binding
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [EquipmentTemplateItem.slot] as an [EquipmentSlot]
 */
fun EquipmentTemplateItem.slot(): EquipmentSlot? = slot.enumValueOrNull<EquipmentSlot>()

/**
 * The [EquipmentTemplateItem.binding] as a [Binding]
 */
fun EquipmentTemplateItem.binding(): Binding? = binding?.enumValueOrNull<Binding>()

/**
 * The [EquipmentTemplateItem.location] as an [ItemLocation]
 */
fun EquipmentTemplateItem.location(): ItemLocation? = location.enumValueOrNull<ItemLocation>()
