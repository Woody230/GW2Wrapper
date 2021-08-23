package com.bselzer.library.gw2.v2.model.enumeration.extension.pvp

import com.bselzer.library.gw2.v2.model.enumeration.profession.ProfessionName
import com.bselzer.library.gw2.v2.model.enumeration.pvp.PvpLadderType
import com.bselzer.library.gw2.v2.model.pvp.stat.PvpStats
import com.bselzer.library.gw2.v2.model.pvp.stat.StatAggregate
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [PvpStats.professionAggregate] with [ProfessionName] keys
 */
fun PvpStats.professionAggregate(): Map<ProfessionName, StatAggregate> = professionAggregate.validEnumValues()

/**
 * The [PvpStats.ladderAggregate] with [PvpLadderType] keys
 */
fun PvpStats.ladderAggregate(): Map<PvpLadderType, StatAggregate> = ladderAggregate.validEnumValues()