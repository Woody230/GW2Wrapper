package com.bselzer.gw2.v2.model.enumeration.extension.item

import com.bselzer.gw2.v2.model.enumeration.item.ConsumableDetailType
import com.bselzer.gw2.v2.model.enumeration.item.ConsumableUnlockType
import com.bselzer.gw2.v2.model.item.detail.ConsumableDetails
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [ConsumableDetails.type] as a [ConsumableDetailType]
 */
fun ConsumableDetails.type(): ConsumableDetailType? = type.enumValueOrNull<ConsumableDetailType>()

/**
 * The [ConsumableDetails.unlockType] as a [ConsumableUnlockType]
 */
fun ConsumableDetails.unlockType(): ConsumableUnlockType? = unlockType?.enumValueOrNull<ConsumableUnlockType>()