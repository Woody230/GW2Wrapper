package com.bselzer.gw2.v2.model.enumeration.extension.account

import com.bselzer.gw2.v2.model.account.build.BuildTemplate
import com.bselzer.gw2.v2.model.enumeration.profession.LegendName
import com.bselzer.gw2.v2.model.enumeration.profession.ProfessionName
import com.bselzer.ktx.serialization.function.enumValueOrNull
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [BuildTemplate.profession] as a [ProfessionName]
 */
fun BuildTemplate.profession(): ProfessionName? = profession.enumValueOrNull<ProfessionName>()

/**
 * The [BuildTemplate.terrestrialLegends] with [LegendName] keys
 */
fun BuildTemplate.terrestrialLegends(): List<LegendName> = terrestrialLegends.validEnumValues()

/**
 * The [BuildTemplate.aquaticLegends] with [LegendName] keys
 */
fun BuildTemplate.aquaticLegends(): List<LegendName> = aquaticLegends.validEnumValues()