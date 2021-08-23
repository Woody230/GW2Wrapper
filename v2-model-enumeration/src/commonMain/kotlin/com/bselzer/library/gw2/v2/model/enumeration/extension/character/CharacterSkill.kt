package com.bselzer.library.gw2.v2.model.enumeration.extension.character

import com.bselzer.library.gw2.v2.model.character.CharacterSkills
import com.bselzer.library.gw2.v2.model.enumeration.profession.LegendName
import com.bselzer.library.kotlin.extension.serialization.function.validEnumValues

/**
 * The [CharacterSkills.legendIds] as a collection of [LegendName]
 */
fun CharacterSkills.legends(): List<LegendName> = legendIds.validEnumValues()