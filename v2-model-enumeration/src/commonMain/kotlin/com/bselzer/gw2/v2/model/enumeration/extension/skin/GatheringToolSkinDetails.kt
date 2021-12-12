package com.bselzer.gw2.v2.model.enumeration.extension.skin

import com.bselzer.gw2.v2.model.enumeration.item.GatheringToolDetailType
import com.bselzer.gw2.v2.model.skin.detail.GatheringToolSkinDetails
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [GatheringToolSkinDetails.type] as a [GatheringToolDetailType]
 */
fun GatheringToolSkinDetails.type(): GatheringToolDetailType? = type.enumValueOrNull<GatheringToolDetailType>()