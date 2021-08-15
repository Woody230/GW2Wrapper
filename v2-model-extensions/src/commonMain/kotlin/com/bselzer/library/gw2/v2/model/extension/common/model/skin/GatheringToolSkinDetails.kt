package com.bselzer.library.gw2.v2.model.extension.common.model.skin

import com.bselzer.library.gw2.v2.model.common.skin.detail.GatheringToolSkinDetails
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.GatheringToolDetailType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [GatheringToolSkinDetails.type] as a [GatheringToolDetailType]
 */
fun GatheringToolSkinDetails.type(): GatheringToolDetailType? = type.enumValueOrNull<GatheringToolDetailType>()