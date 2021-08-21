package com.bselzer.library.gw2.v2.model.extension.common.model.character

import com.bselzer.library.gw2.v2.model.common.character.CharacterSkills
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.LegendName
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [CharacterSkills.legendIds] as a collection of [LegendName]
 */
fun CharacterSkills.legends(): List<LegendName> = legendIds.validEnumValues()