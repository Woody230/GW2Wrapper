package com.bselzer.library.gw2.v2.model.enumeration.extension.achievement

import com.bselzer.library.gw2.v2.model.achievement.daily.DailyAccess
import com.bselzer.library.gw2.v2.model.enumeration.scope.Accessibility
import com.bselzer.library.gw2.v2.model.enumeration.scope.Product
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [DailyAccess.product] as a [Product]
 */
fun DailyAccess.product(): Product? = product.enumValueOrNull<Product>()

/**
 * The [DailyAccess.accessibility] as an [Accessibility]
 */
fun DailyAccess.accessibility(): Accessibility? = accessibility.enumValueOrNull<Accessibility>()