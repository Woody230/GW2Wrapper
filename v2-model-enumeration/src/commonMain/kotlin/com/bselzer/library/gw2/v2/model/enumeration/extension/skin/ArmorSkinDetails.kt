package com.bselzer.library.gw2.v2.model.enumeration.extension.skin

import com.bselzer.library.gw2.v2.model.enumeration.item.ArmorDetailType
import com.bselzer.library.gw2.v2.model.skin.detail.ArmorSkinDetails
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [ArmorSkinDetails.type] as an [ArmorDetailType]
 */
fun ArmorSkinDetails.type(): ArmorDetailType? = type.enumValueOrNull<ArmorDetailType>()