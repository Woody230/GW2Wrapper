package com.bselzer.library.gw2.v2.model.extension.common.model.skin

import com.bselzer.library.gw2.v2.model.common.skin.detail.ArmorSkinDyeSlot
import com.bselzer.library.gw2.v2.model.common.skin.detail.ArmorSkinDyeSlots
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skin.ArmorSkinDyeOverride
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [ArmorSkinDyeSlots.overrides] with [ArmorSkinDyeOverride] keys
 */
fun ArmorSkinDyeSlots.overrides(): Map<ArmorSkinDyeOverride, ArmorSkinDyeSlot> = overrides.validEnumValues()