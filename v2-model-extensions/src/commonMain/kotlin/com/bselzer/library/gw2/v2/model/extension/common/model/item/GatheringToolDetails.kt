package com.bselzer.library.gw2.v2.model.extension.common.model.item

import com.bselzer.library.gw2.v2.model.common.item.detail.GatheringToolDetails
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.GatheringToolDetailType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [GatheringToolDetails.type] as a [GatheringToolDetailType]
 */
fun GatheringToolDetails.type(): GatheringToolDetailType? = type.enumValueOrNull<GatheringToolDetailType>()