package com.bselzer.gw2.v2.model.enumeration.extension.item

import com.bselzer.gw2.v2.model.enumeration.item.TrinketDetailType
import com.bselzer.gw2.v2.model.item.detail.TrinketDetails
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [TrinketDetails.type] as a [TrinketDetailType]
 */
fun TrinketDetails.type(): TrinketDetailType? = type.enumValueOrNull<TrinketDetailType>()