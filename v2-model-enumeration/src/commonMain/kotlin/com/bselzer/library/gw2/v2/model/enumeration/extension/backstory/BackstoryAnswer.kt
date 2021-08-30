package com.bselzer.library.gw2.v2.model.enumeration.extension.backstory

import com.bselzer.library.gw2.v2.model.backstory.BackstoryAnswer
import com.bselzer.library.gw2.v2.model.enumeration.character.RaceName
import com.bselzer.library.gw2.v2.model.enumeration.profession.ProfessionName
import com.bselzer.library.kotlin.extension.serialization.function.validEnumValues

/**
 * The [BackstoryAnswer.professions] as a collection of [ProfessionName]
 */
fun BackstoryAnswer.professions(): List<ProfessionName> = professions.validEnumValues()

/**
 * The [BackstoryAnswer.races] as a collection of [RaceName]
 */
fun BackstoryAnswer.races(): List<RaceName> = races.validEnumValues()