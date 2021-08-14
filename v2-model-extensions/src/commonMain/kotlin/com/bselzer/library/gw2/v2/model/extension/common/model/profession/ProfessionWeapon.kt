package com.bselzer.library.gw2.v2.model.extension.common.model.profession

import com.bselzer.library.gw2.v2.model.common.profession.ProfessionWeapon
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.WeaponFlag
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

/**
 * The [ProfessionWeapon.flags] as a collection of [WeaponFlag]
 */
fun ProfessionWeapon.flags(): List<WeaponFlag> = flags.validEnumValues()