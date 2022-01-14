package com.bselzer.gw2.v2.model.enumeration.extension.skin

import com.bselzer.gw2.v2.model.enumeration.skin.ArmorSkinDyeOverride
import com.bselzer.gw2.v2.model.skin.detail.ArmorSkinDyeSlot
import com.bselzer.gw2.v2.model.skin.detail.ArmorSkinDyeSlots
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [ArmorSkinDyeSlots.overrides] with [ArmorSkinDyeOverride] keys
 */
fun ArmorSkinDyeSlots.overrides(): Map<ArmorSkinDyeOverride, ArmorSkinDyeSlot> = overrides.validEnumValues()