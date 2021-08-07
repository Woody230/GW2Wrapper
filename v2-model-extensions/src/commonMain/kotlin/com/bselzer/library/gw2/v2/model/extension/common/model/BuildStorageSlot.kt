package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.account.build.BuildStorageSlot
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.LegendName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.ProfessionName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

/**
 * The [BuildStorageSlot.profession] as a [ProfessionName]
 */
fun BuildStorageSlot.profession(): ProfessionName? = profession.enumValueOrNull<ProfessionName>()

/**
 * The [BuildStorageSlot.terrestrialLegends] with [LegendName] keys
 */
fun BuildStorageSlot.terrestrialLegends(): List<LegendName> = terrestrialLegends.validEnumValues()

/**
 * The [BuildStorageSlot.aquaticLegends] with [LegendName] keys
 */
fun BuildStorageSlot.aquaticLegends(): List<LegendName> = aquaticLegends.validEnumValues()