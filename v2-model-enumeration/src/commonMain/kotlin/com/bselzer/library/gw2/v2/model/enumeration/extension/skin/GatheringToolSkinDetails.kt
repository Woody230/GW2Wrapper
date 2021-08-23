package com.bselzer.library.gw2.v2.model.enumeration.extension.skin

import com.bselzer.library.gw2.v2.model.enumeration.item.GatheringToolDetailType
import com.bselzer.library.gw2.v2.model.skin.detail.GatheringToolSkinDetails
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [GatheringToolSkinDetails.type] as a [GatheringToolDetailType]
 */
fun GatheringToolSkinDetails.type(): GatheringToolDetailType? = type.enumValueOrNull<GatheringToolDetailType>()