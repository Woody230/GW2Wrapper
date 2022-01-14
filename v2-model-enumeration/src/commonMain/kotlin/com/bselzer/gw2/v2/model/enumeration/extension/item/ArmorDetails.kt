package com.bselzer.gw2.v2.model.enumeration.extension.item

import com.bselzer.gw2.v2.model.enumeration.item.ArmorDetailType
import com.bselzer.gw2.v2.model.enumeration.item.ArmorWeight
import com.bselzer.gw2.v2.model.item.detail.ArmorDetails
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [ArmorDetails.type] as an [ArmorDetailType]
 */
fun ArmorDetails.type(): ArmorDetailType? = type.enumValueOrNull<ArmorDetailType>()

/**
 * The [ArmorDetails.weightClass] as an [ArmorWeight]
 */
fun ArmorDetails.weightClass(): ArmorWeight? = weightClass.enumValueOrNull<ArmorWeight>()