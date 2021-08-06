package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.character.CharacterEquipment
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.character.EquipmentSlot
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.scope.Binding
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [CharacterEquipment.slot] as an [EquipmentSlot]
 */
fun CharacterEquipment.slot(): EquipmentSlot? = slot.enumValueOrNull<EquipmentSlot>()

/**
 * The [CharacterEquipment.binding] as a [Binding]
 */
fun CharacterEquipment.binding(): Binding? = binding?.enumValueOrNull<Binding>()