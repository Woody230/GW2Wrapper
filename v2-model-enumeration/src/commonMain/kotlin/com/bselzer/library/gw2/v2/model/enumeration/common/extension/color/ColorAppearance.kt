package com.bselzer.library.gw2.v2.model.enumeration.common.extension.color

import com.bselzer.library.gw2.v2.model.common.color.DyeColor
import com.bselzer.library.gw2.v2.model.enumeration.common.color.ColorCategory
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [DyeColor.categories] as a collection of [ColorCategory]
 */
fun DyeColor.categories(): List<ColorCategory> = categories.validEnumValues()