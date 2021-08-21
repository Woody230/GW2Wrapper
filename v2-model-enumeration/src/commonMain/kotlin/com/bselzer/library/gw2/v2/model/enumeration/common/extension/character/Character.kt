package com.bselzer.library.gw2.v2.model.enumeration.common.extension.character

import com.bselzer.library.gw2.v2.model.common.character.Character
import com.bselzer.library.gw2.v2.model.enumeration.common.character.CharacterFlag
import com.bselzer.library.gw2.v2.model.enumeration.common.character.Gender
import com.bselzer.library.gw2.v2.model.enumeration.common.character.RaceName
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.ProfessionName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

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