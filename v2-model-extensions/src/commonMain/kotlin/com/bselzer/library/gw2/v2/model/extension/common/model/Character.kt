package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.character.Character
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.character.CharacterFlag
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.character.Gender
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.character.RaceName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.ProfessionName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

/**
 * The [Character.race] as a [RaceName]
 */
fun Character.race(): RaceName? = race.enumValueOrNull<RaceName>()

/**
 * The [Character.gender] as a [Gender]
 */
fun Character.gender(): Gender? = race.enumValueOrNull<Gender>()

/**
 * The [Character.profession] as a [ProfessionName]
 */
fun Character.profession(): ProfessionName? = profession.enumValueOrNull<ProfessionName>()

/**
 * The [Character.flags] as a collection of [CharacterFlag]
 */
fun Character.flags(): List<CharacterFlag> = flags.validEnumValues()