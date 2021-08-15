package com.bselzer.library.gw2.v2.model.extension.common.model.skin

import com.bselzer.library.gw2.v2.model.common.skin.detail.ArmorSkinDyeSlot
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.skin.ArmorSkinMaterialType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [ArmorSkinDyeSlot.material] as an [ArmorSkinMaterialType]
 */
fun ArmorSkinDyeSlot.material(): ArmorSkinMaterialType? = material.enumValueOrNull<ArmorSkinMaterialType>()