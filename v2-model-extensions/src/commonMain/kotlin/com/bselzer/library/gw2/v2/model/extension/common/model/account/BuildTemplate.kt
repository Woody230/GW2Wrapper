package com.bselzer.library.gw2.v2.model.extension.common.model.account

import com.bselzer.library.gw2.v2.model.common.account.build.BuildTemplate
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.LegendName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.ProfessionName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

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