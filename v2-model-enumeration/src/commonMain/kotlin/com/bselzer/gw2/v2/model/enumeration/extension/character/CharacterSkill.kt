package com.bselzer.gw2.v2.model.enumeration.extension.character

import com.bselzer.gw2.v2.model.character.skill.CharacterSkills
import com.bselzer.gw2.v2.model.enumeration.profession.LegendName
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [CharacterSkills.legendIds] as a collection of [LegendName]
 */
fun CharacterSkills.legends(): List<LegendName> = legendIds.map { it?.value }.validEnumValues()