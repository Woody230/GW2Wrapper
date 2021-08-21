package com.bselzer.library.gw2.v2.model.extension.common.model.pvp

import com.bselzer.library.gw2.v2.model.common.pvp.season.PvpDivision
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.pvp.PvpDivisionFlag
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [PvpDivision.flags] as a collection of [PvpDivisionFlag]
 */
fun PvpDivision.flags(): List<PvpDivisionFlag> = flags.validEnumValues()