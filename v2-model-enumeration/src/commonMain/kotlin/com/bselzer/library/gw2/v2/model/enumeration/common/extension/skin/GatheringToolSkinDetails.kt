package com.bselzer.library.gw2.v2.model.enumeration.common.extension.skin

import com.bselzer.library.gw2.v2.model.common.skin.detail.GatheringToolSkinDetails
import com.bselzer.library.gw2.v2.model.enumeration.common.item.GatheringToolDetailType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [GatheringToolSkinDetails.type] as a [GatheringToolDetailType]
 */
fun GatheringToolSkinDetails.type(): GatheringToolDetailType? = type.enumValueOrNull<GatheringToolDetailType>()