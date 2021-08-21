package com.bselzer.library.gw2.v2.model.enumeration.common.extension.skin

import com.bselzer.library.gw2.v2.model.common.skin.detail.ArmorSkinDetails
import com.bselzer.library.gw2.v2.model.enumeration.common.item.ArmorDetailType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [ArmorSkinDetails.type] as an [ArmorDetailType]
 */
fun ArmorSkinDetails.type(): ArmorDetailType? = type.enumValueOrNull<ArmorDetailType>()