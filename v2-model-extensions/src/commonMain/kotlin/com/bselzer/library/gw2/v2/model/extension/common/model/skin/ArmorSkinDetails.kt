package com.bselzer.library.gw2.v2.model.extension.common.model.skin

import com.bselzer.library.gw2.v2.model.common.skin.detail.ArmorSkinDetails
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.ArmorDetailType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [ArmorSkinDetails.type] as an [ArmorDetailType]
 */
fun ArmorSkinDetails.type(): ArmorDetailType? = type.enumValueOrNull<ArmorDetailType>()