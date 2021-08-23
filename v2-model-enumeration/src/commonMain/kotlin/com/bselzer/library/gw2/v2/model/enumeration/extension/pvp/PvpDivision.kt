package com.bselzer.library.gw2.v2.model.enumeration.extension.pvp

import com.bselzer.library.gw2.v2.model.enumeration.pvp.PvpDivisionFlag
import com.bselzer.library.gw2.v2.model.pvp.season.PvpDivision
import com.bselzer.library.kotlin.extension.serialization.function.validEnumValues

/**
 * The [PvpDivision.flags] as a collection of [PvpDivisionFlag]
 */
fun PvpDivision.flags(): List<PvpDivisionFlag> = flags.validEnumValues()