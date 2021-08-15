package com.bselzer.library.gw2.v2.model.extension.common.model.backstory

import com.bselzer.library.gw2.v2.model.common.backstory.BackstoryQuestion
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.character.RaceName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.ProfessionName
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

/**
 * The [BackstoryQuestion.professions] as a collection of [ProfessionName]
 */
fun BackstoryQuestion.professions(): List<ProfessionName> = professions.validEnumValues()

/**
 * The [BackstoryQuestion.races] as a collection of [RaceName]
 */
fun BackstoryQuestion.races(): List<RaceName> = races.validEnumValues()