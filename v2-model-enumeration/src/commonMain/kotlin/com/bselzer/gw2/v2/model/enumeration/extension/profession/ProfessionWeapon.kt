package com.bselzer.gw2.v2.model.enumeration.extension.profession

import com.bselzer.gw2.v2.model.enumeration.profession.WeaponFlag
import com.bselzer.gw2.v2.model.profession.ProfessionWeapon
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [ProfessionWeapon.flags] as a collection of [WeaponFlag]
 */
fun ProfessionWeapon.flags(): List<WeaponFlag> = flags.validEnumValues()