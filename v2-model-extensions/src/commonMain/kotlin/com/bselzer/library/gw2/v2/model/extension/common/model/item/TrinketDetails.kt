package com.bselzer.library.gw2.v2.model.extension.common.model.item

import com.bselzer.library.gw2.v2.model.common.item.detail.TrinketDetails
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.TrinketDetailType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [TrinketDetails.type] as a [TrinketDetailType]
 */
fun TrinketDetails.type(): TrinketDetailType? = type.enumValueOrNull<TrinketDetailType>()