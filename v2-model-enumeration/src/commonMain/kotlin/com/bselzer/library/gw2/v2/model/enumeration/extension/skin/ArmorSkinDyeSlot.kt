package com.bselzer.library.gw2.v2.model.enumeration.extension.skin

import com.bselzer.library.gw2.v2.model.enumeration.skin.ArmorSkinMaterialType
import com.bselzer.library.gw2.v2.model.skin.detail.ArmorSkinDyeSlot
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [ArmorSkinDyeSlot.material] as an [ArmorSkinMaterialType]
 */
fun ArmorSkinDyeSlot.material(): ArmorSkinMaterialType? = material.enumValueOrNull<ArmorSkinMaterialType>()