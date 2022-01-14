package com.bselzer.gw2.v2.model.enumeration.extension.character

import com.bselzer.gw2.v2.model.character.Character
import com.bselzer.gw2.v2.model.enumeration.character.CharacterFlag
import com.bselzer.gw2.v2.model.enumeration.character.Gender
import com.bselzer.gw2.v2.model.enumeration.character.RaceName
import com.bselzer.gw2.v2.model.enumeration.profession.ProfessionName
import com.bselzer.ktx.serialization.function.enumValueOrNull
import com.bselzer.ktx.serialization.function.validEnumValues

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