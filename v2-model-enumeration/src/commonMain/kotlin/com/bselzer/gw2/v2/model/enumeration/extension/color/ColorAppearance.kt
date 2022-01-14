package com.bselzer.gw2.v2.model.enumeration.extension.color

import com.bselzer.gw2.v2.model.color.DyeColor
import com.bselzer.gw2.v2.model.enumeration.color.ColorCategory
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [DyeColor.categories] as a collection of [ColorCategory]
 */
fun DyeColor.categories(): List<ColorCategory> = categories.validEnumValues()