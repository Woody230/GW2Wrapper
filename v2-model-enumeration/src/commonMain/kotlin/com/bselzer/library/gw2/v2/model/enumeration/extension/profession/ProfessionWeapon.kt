package com.bselzer.library.gw2.v2.model.enumeration.extension.profession

import com.bselzer.library.gw2.v2.model.enumeration.profession.WeaponFlag
import com.bselzer.library.gw2.v2.model.profession.ProfessionWeapon
import com.bselzer.library.kotlin.extension.serialization.function.validEnumValues

/**
 * The [ProfessionWeapon.flags] as a collection of [WeaponFlag]
 */
fun ProfessionWeapon.flags(): List<WeaponFlag> = flags.validEnumValues()