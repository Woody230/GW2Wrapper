package com.bselzer.library.gw2.v2.model.enumeration.common.extension.skin

import com.bselzer.library.gw2.v2.model.common.skin.detail.ArmorSkinDyeSlot
import com.bselzer.library.gw2.v2.model.enumeration.common.skin.ArmorSkinMaterialType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [ArmorSkinDyeSlot.material] as an [ArmorSkinMaterialType]
 */
fun ArmorSkinDyeSlot.material(): ArmorSkinMaterialType? = material.enumValueOrNull<ArmorSkinMaterialType>()