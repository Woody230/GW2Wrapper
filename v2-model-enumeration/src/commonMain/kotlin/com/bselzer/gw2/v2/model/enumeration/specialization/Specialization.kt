package com.bselzer.gw2.v2.model.enumeration.specialization

import com.bselzer.gw2.v2.model.enumeration.profession.ProfessionName
import com.bselzer.gw2.v2.model.enumeration.profession.SpecializationName
import com.bselzer.gw2.v2.model.specialization.Specialization
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [Specialization.name] as a [SpecializationName]
 */
fun Specialization.name(): SpecializationName? = name.enumValueOrNull<SpecializationName>()

/**
 * The [Specialization.profession] as a [ProfessionName]
 */
fun Specialization.profession(): ProfessionName? = profession.enumValueOrNull<ProfessionName>()