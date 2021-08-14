package com.bselzer.library.gw2.v2.model.extension.common.model.account

import com.bselzer.library.gw2.v2.model.common.account.build.EquipmentTemplateItem
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.character.EquipmentSlot
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.ItemLocation
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.scope.Binding
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

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
