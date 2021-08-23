package com.bselzer.library.gw2.v2.model.enumeration.extension.skin

import com.bselzer.library.gw2.v2.model.enumeration.skin.ArmorSkinDyeOverride
import com.bselzer.library.gw2.v2.model.skin.detail.ArmorSkinDyeSlot
import com.bselzer.library.gw2.v2.model.skin.detail.ArmorSkinDyeSlots
import com.bselzer.library.kotlin.extension.serialization.function.validEnumValues

/**
 * The [ArmorSkinDyeSlots.overrides] with [ArmorSkinDyeOverride] keys
 */
fun ArmorSkinDyeSlots.overrides(): Map<ArmorSkinDyeOverride, ArmorSkinDyeSlot> = overrides.validEnumValues()