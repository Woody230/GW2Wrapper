package com.bselzer.gw2.v2.model.enumeration.extension.account

import com.bselzer.gw2.v2.model.account.equipment.EquipmentTemplateItem
import com.bselzer.gw2.v2.model.enumeration.character.EquipmentSlot
import com.bselzer.gw2.v2.model.enumeration.item.ItemLocation
import com.bselzer.gw2.v2.model.enumeration.scope.Binding
import com.bselzer.ktx.serialization.function.enumValueOrNull

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
