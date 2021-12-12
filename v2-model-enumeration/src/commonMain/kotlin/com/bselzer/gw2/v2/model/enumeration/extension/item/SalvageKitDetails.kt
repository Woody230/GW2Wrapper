package com.bselzer.gw2.v2.model.enumeration.extension.item

import com.bselzer.gw2.v2.model.enumeration.item.SalvageKitDetailType
import com.bselzer.gw2.v2.model.item.detail.SalvageKitDetails
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [SalvageKitDetails.type] as a [SalvageKitDetailType]
 */
fun SalvageKitDetails.type(): SalvageKitDetailType? = type.enumValueOrNull<SalvageKitDetailType>()