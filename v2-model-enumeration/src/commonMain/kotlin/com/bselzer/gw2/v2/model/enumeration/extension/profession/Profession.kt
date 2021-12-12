package com.bselzer.gw2.v2.model.enumeration.extension.profession

import com.bselzer.gw2.v2.model.enumeration.profession.ProfessionFlag
import com.bselzer.gw2.v2.model.enumeration.profession.ProfessionName
import com.bselzer.gw2.v2.model.enumeration.profession.WeaponType
import com.bselzer.gw2.v2.model.profession.Profession
import com.bselzer.gw2.v2.model.profession.ProfessionWeapon
import com.bselzer.ktx.serialization.function.enumValueOrNull
import com.bselzer.ktx.serialization.function.validEnumValues

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