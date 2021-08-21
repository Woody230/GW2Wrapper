package com.bselzer.library.gw2.v2.model.enumeration.common.extension.item

import com.bselzer.library.gw2.v2.model.common.item.detail.TrinketDetails
import com.bselzer.library.gw2.v2.model.enumeration.common.item.TrinketDetailType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [TrinketDetails.type] as a [TrinketDetailType]
 */
fun TrinketDetails.type(): TrinketDetailType? = type.enumValueOrNull<TrinketDetailType>()