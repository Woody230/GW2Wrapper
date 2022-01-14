package com.bselzer.gw2.v2.model.enumeration.extension.backstory

import com.bselzer.gw2.v2.model.backstory.BackstoryQuestion
import com.bselzer.gw2.v2.model.enumeration.character.RaceName
import com.bselzer.gw2.v2.model.enumeration.profession.ProfessionName
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [BackstoryQuestion.professions] as a collection of [ProfessionName]
 */
fun BackstoryQuestion.professions(): List<ProfessionName> = professions.validEnumValues()

/**
 * The [BackstoryQuestion.races] as a collection of [RaceName]
 */
fun BackstoryQuestion.races(): List<RaceName> = races.validEnumValues()