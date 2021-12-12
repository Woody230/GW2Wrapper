package com.bselzer.gw2.v2.model.enumeration.extension.skin

import com.bselzer.gw2.v2.model.enumeration.item.WeaponDamageType
import com.bselzer.gw2.v2.model.enumeration.item.WeaponDetailType
import com.bselzer.gw2.v2.model.skin.detail.WeaponSkinDetails
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [WeaponSkinDetails.type] as a [WeaponDetailType]
 */
fun WeaponSkinDetails.type(): WeaponDetailType? = type.enumValueOrNull<WeaponDetailType>()

/**
 * The [WeaponSkinDetails.damageType] as a [WeaponDamageType]
 */
fun WeaponSkinDetails.damageType(): WeaponDamageType? = damageType.enumValueOrNull<WeaponDamageType>()