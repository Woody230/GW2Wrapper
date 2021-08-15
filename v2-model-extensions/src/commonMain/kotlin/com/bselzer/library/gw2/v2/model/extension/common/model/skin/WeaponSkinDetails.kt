package com.bselzer.library.gw2.v2.model.extension.common.model.skin

import com.bselzer.library.gw2.v2.model.common.skin.detail.WeaponSkinDetails
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.WeaponDamageType
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.WeaponDetailType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [WeaponSkinDetails.type] as a [WeaponDetailType]
 */
fun WeaponSkinDetails.type(): WeaponDetailType? = type.enumValueOrNull<WeaponDetailType>()

/**
 * The [WeaponSkinDetails.damageType] as a [WeaponDamageType]
 */
fun WeaponSkinDetails.damageType(): WeaponDamageType? = damageType.enumValueOrNull<WeaponDamageType>()