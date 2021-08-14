package com.bselzer.library.gw2.v2.model.extension.common.model.item

import com.bselzer.library.gw2.v2.model.common.item.detail.ArmorDetails
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.ArmorDetailType
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.ArmorWeight
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [ArmorDetails.type] as an [ArmorDetailType]
 */
fun ArmorDetails.type(): ArmorDetailType? = type.enumValueOrNull<ArmorDetailType>()

/**
 * The [ArmorDetails.weightClass] as an [ArmorWeight]
 */
fun ArmorDetails.weightClass(): ArmorWeight? = weightClass.enumValueOrNull<ArmorWeight>()