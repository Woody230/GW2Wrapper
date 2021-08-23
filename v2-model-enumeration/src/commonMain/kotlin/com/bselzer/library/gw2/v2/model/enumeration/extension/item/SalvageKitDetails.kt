package com.bselzer.library.gw2.v2.model.enumeration.extension.item

import com.bselzer.library.gw2.v2.model.enumeration.item.SalvageKitDetailType
import com.bselzer.library.gw2.v2.model.item.detail.SalvageKitDetails
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [SalvageKitDetails.type] as a [SalvageKitDetailType]
 */
fun SalvageKitDetails.type(): SalvageKitDetailType? = type.enumValueOrNull<SalvageKitDetailType>()