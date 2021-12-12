package com.bselzer.gw2.v2.model.enumeration.extension.character

import com.bselzer.gw2.v2.model.character.CharacterEquipment
import com.bselzer.gw2.v2.model.enumeration.character.EquipmentSlot
import com.bselzer.gw2.v2.model.enumeration.scope.Binding
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [CharacterEquipment.slot] as an [EquipmentSlot]
 */
fun CharacterEquipment.slot(): EquipmentSlot? = slot.enumValueOrNull<EquipmentSlot>()

/**
 * The [CharacterEquipment.binding] as a [Binding]
 */
fun CharacterEquipment.binding(): Binding? = binding?.enumValueOrNull<Binding>()