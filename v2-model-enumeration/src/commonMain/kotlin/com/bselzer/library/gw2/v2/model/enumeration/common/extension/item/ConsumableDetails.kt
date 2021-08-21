package com.bselzer.library.gw2.v2.model.enumeration.common.extension.item

import com.bselzer.library.gw2.v2.model.common.item.detail.ConsumableDetails
import com.bselzer.library.gw2.v2.model.enumeration.common.item.ConsumableDetailType
import com.bselzer.library.gw2.v2.model.enumeration.common.item.ConsumableUnlockType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [ConsumableDetails.type] as a [ConsumableDetailType]
 */
fun ConsumableDetails.type(): ConsumableDetailType? = type.enumValueOrNull<ConsumableDetailType>()

/**
 * The [ConsumableDetails.unlockType] as a [ConsumableUnlockType]
 */
fun ConsumableDetails.unlockType(): ConsumableUnlockType? = unlockType?.enumValueOrNull<ConsumableUnlockType>()