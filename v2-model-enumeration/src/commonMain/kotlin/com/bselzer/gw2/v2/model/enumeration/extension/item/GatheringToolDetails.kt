package com.bselzer.gw2.v2.model.enumeration.extension.item

import com.bselzer.gw2.v2.model.enumeration.item.GatheringToolDetailType
import com.bselzer.gw2.v2.model.item.detail.GatheringToolDetails
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [GatheringToolDetails.type] as a [GatheringToolDetailType]
 */
fun GatheringToolDetails.type(): GatheringToolDetailType? = type.enumValueOrNull<GatheringToolDetailType>()