package com.bselzer.library.gw2.v2.model.enumeration.common.extension.backstory

import com.bselzer.library.gw2.v2.model.common.backstory.BackstoryQuestion
import com.bselzer.library.gw2.v2.model.enumeration.common.character.RaceName
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.ProfessionName
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [BackstoryQuestion.professions] as a collection of [ProfessionName]
 */
fun BackstoryQuestion.professions(): List<ProfessionName> = professions.validEnumValues()

/**
 * The [BackstoryQuestion.races] as a collection of [RaceName]
 */
fun BackstoryQuestion.races(): List<RaceName> = races.validEnumValues()