package com.bselzer.gw2.v2.model.enumeration.extension.skin

import com.bselzer.gw2.v2.model.enumeration.item.ArmorDetailType
import com.bselzer.gw2.v2.model.skin.detail.ArmorSkinDetails
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [ArmorSkinDetails.type] as an [ArmorDetailType]
 */
fun ArmorSkinDetails.type(): ArmorDetailType? = type.enumValueOrNull<ArmorDetailType>()