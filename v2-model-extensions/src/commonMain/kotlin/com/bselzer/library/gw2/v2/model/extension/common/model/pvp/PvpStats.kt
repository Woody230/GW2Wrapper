package com.bselzer.library.gw2.v2.model.extension.common.model.pvp

import com.bselzer.library.gw2.v2.model.common.pvp.stat.PvpStats
import com.bselzer.library.gw2.v2.model.common.pvp.stat.StatAggregate
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.ProfessionName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.pvp.PvpLadderType
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

/**
 * The [PvpStats.professionAggregate] with [ProfessionName] keys
 */
fun PvpStats.professionAggregate(): Map<ProfessionName, StatAggregate> = professionAggregate.validEnumValues()

/**
 * The [PvpStats.ladderAggregate] with [PvpLadderType] keys
 */
fun PvpStats.ladderAggregate(): Map<PvpLadderType, StatAggregate> = ladderAggregate.validEnumValues()