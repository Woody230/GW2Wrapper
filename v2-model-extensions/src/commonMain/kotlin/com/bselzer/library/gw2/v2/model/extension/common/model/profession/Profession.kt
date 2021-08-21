package com.bselzer.library.gw2.v2.model.extension.common.model.profession

import com.bselzer.library.gw2.v2.model.common.profession.Profession
import com.bselzer.library.gw2.v2.model.common.profession.ProfessionWeapon
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.ProfessionFlag
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.ProfessionName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.WeaponType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [Profession.name] as a [ProfessionName]
 */
fun Profession.name(): ProfessionName? = name.enumValueOrNull<ProfessionName>()

/**
 * The [Profession.weapons] with [WeaponType] keys
 */
fun Profession.weapons(): Map<WeaponType, ProfessionWeapon> = weapons.validEnumValues()

/**
 * The [Profession.flags] as a collection of [ProfessionFlag]
 */
fun Profession.flags(): List<ProfessionFlag> = flags.validEnumValues()