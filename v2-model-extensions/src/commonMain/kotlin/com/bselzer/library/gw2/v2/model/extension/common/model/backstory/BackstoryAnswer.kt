package com.bselzer.library.gw2.v2.model.extension.common.model.backstory

import com.bselzer.library.gw2.v2.model.common.backstory.BackstoryAnswer
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.character.RaceName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.ProfessionName
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [BackstoryAnswer.professions] as a collection of [ProfessionName]
 */
fun BackstoryAnswer.professions(): List<ProfessionName> = professions.validEnumValues()

/**
 * The [BackstoryAnswer.races] as a collection of [RaceName]
 */
fun BackstoryAnswer.races(): List<RaceName> = races.validEnumValues()