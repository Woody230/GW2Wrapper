package com.bselzer.library.gw2.v2.model.enumeration.extension.color

import com.bselzer.library.gw2.v2.model.color.DyeColor
import com.bselzer.library.gw2.v2.model.enumeration.color.ColorCategory
import com.bselzer.library.kotlin.extension.serialization.function.validEnumValues

/**
 * The [DyeColor.categories] as a collection of [ColorCategory]
 */
fun DyeColor.categories(): List<ColorCategory> = categories.validEnumValues()