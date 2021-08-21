package com.bselzer.library.gw2.v2.model.extension.common.model.item

import com.bselzer.library.gw2.v2.model.common.item.detail.SalvageKitDetails
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.SalvageKitDetailType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [SalvageKitDetails.type] as a [SalvageKitDetailType]
 */
fun SalvageKitDetails.type(): SalvageKitDetailType? = type.enumValueOrNull<SalvageKitDetailType>()