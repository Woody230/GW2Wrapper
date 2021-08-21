package com.bselzer.library.gw2.v2.model.enumeration.common.extension.pvp

import com.bselzer.library.gw2.v2.model.common.pvp.PvpGame
import com.bselzer.library.gw2.v2.model.enumeration.common.profession.ProfessionName
import com.bselzer.library.gw2.v2.model.enumeration.common.pvp.PvpResult
import com.bselzer.library.gw2.v2.model.enumeration.common.pvp.PvpTeam
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [PvpGame.result] as a [PvpResult]
 */
fun PvpGame.result(): PvpResult? = result.enumValueOrNull<PvpResult>()

/**
 * The [PvpGame.team] as a [PvpTeam]
 */
fun PvpGame.team(): PvpTeam? = team.enumValueOrNull<PvpTeam>()

/**
 * The [PvpGame.profession] as a [ProfessionName]
 */
fun PvpGame.profession(): ProfessionName? = profession.enumValueOrNull<ProfessionName>()

/**
 * The [PvpGame.scores] with [PvpTeam] keys
 */
fun PvpGame.scores(): Map<PvpTeam, Int> = scores.validEnumValues()