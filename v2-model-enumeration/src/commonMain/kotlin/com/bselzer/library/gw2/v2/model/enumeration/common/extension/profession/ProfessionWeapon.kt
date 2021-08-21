package com.bselzer.library.gw2.v2.model.enumeration.common.extension.profession

import com.bselzer.library.gw2.v2.model.common.profession.ProfessionWeapon
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.WeaponFlag
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [ProfessionWeapon.flags] as a collection of [WeaponFlag]
 */
fun ProfessionWeapon.flags(): List<WeaponFlag> = flags.validEnumValues()