package com.bselzer.library.gw2.v2.model.enumeration.common.extension.pvp

import com.bselzer.library.gw2.v2.model.common.pvp.stat.PvpStats
import com.bselzer.library.gw2.v2.model.common.pvp.stat.StatAggregate
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.ProfessionName
import com.bselzer.library.gw2.v2.model.enumeration.common.pvp.PvpLadderType
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [PvpStats.professionAggregate] with [ProfessionName] keys
 */
fun PvpStats.professionAggregate(): Map<ProfessionName, StatAggregate> = professionAggregate.validEnumValues()

/**
 * The [PvpStats.ladderAggregate] with [PvpLadderType] keys
 */
fun PvpStats.ladderAggregate(): Map<PvpLadderType, StatAggregate> = ladderAggregate.validEnumValues()