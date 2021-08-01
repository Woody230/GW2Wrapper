package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.achievement.daily.DailyAccess
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.scope.Accessibility
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.scope.Product
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [DailyAccess.product] as a [Product]
 */
fun DailyAccess.product(): Product? = product.enumValueOrNull<Product>()

/**
 * The [DailyAccess.accessibility] as an [Accessibility]
 */
fun DailyAccess.accessibility(): Accessibility? = accessibility.enumValueOrNull<Accessibility>()