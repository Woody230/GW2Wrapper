package com.bselzer.library.gw2.v2.model.extension.common.model.item

import com.bselzer.library.gw2.v2.model.common.item.detail.GatheringToolDetails
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.GatheringToolDetailType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [GatheringToolDetails.type] as a [GatheringToolDetailType]
 */
fun GatheringToolDetails.type(): GatheringToolDetailType? = type.enumValueOrNull<GatheringToolDetailType>()