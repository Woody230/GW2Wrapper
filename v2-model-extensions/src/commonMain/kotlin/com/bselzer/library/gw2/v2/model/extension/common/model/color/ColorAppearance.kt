package com.bselzer.library.gw2.v2.model.extension.common.model.color

import com.bselzer.library.gw2.v2.model.common.color.DyeColor
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.color.ColorCategory
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

/**
 * The [DyeColor.categories] as a collection of [ColorCategory]
 */
fun DyeColor.categories(): List<ColorCategory> = categories.validEnumValues()