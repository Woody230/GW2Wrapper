package com.bselzer.library.gw2.v2.model.extension.common.model.item

import com.bselzer.library.gw2.v2.model.common.item.detail.WeaponDetails
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.WeaponDamageType
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.WeaponDetailType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [WeaponDetails.type] as an [WeaponDetailType]
 */
fun WeaponDetails.type(): WeaponDetailType? = type.enumValueOrNull<WeaponDetailType>()

/**
 * The [WeaponDetails.damageType] as a [WeaponDamageType]
 */
fun WeaponDetails.damageType(): WeaponDamageType? = damageType.enumValueOrNull<WeaponDamageType>()