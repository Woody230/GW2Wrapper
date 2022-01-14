package com.bselzer.gw2.v2.model.enumeration.extension.pvp

import com.bselzer.gw2.v2.model.enumeration.profession.ProfessionName
import com.bselzer.gw2.v2.model.enumeration.pvp.PvpLadderType
import com.bselzer.gw2.v2.model.pvp.stat.PvpStats
import com.bselzer.gw2.v2.model.pvp.stat.StatAggregate
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [PvpStats.professionAggregate] with [ProfessionName] keys
 */
fun PvpStats.professionAggregate(): Map<ProfessionName, StatAggregate> = professionAggregate.validEnumValues()

/**
 * The [PvpStats.ladderAggregate] with [PvpLadderType] keys
 */
fun PvpStats.ladderAggregate(): Map<PvpLadderType, StatAggregate> = ladderAggregate.validEnumValues()