package com.bselzer.library.gw2.v2.model.enumeration.specialization

import com.bselzer.library.gw2.v2.model.enumeration.profession.ProfessionName
import com.bselzer.library.gw2.v2.model.enumeration.profession.SpecializationName
import com.bselzer.library.gw2.v2.model.specialization.Specialization
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [Specialization.name] as a [SpecializationName]
 */
fun Specialization.name(): SpecializationName? = name.enumValueOrNull<SpecializationName>()

/**
 * The [Specialization.profession] as a [ProfessionName]
 */
fun Specialization.profession(): ProfessionName? = profession.enumValueOrNull<ProfessionName>()