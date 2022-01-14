package com.bselzer.gw2.v2.model.enumeration.extension.backstory

import com.bselzer.gw2.v2.model.backstory.BackstoryAnswer
import com.bselzer.gw2.v2.model.enumeration.character.RaceName
import com.bselzer.gw2.v2.model.enumeration.profession.ProfessionName
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [BackstoryAnswer.professions] as a collection of [ProfessionName]
 */
fun BackstoryAnswer.professions(): List<ProfessionName> = professions.validEnumValues()

/**
 * The [BackstoryAnswer.races] as a collection of [RaceName]
 */
fun BackstoryAnswer.races(): List<RaceName> = races.validEnumValues()