package com.bselzer.gw2.v2.model.enumeration.extension.pvp

import com.bselzer.gw2.v2.model.enumeration.profession.ProfessionName
import com.bselzer.gw2.v2.model.enumeration.pvp.PvpResult
import com.bselzer.gw2.v2.model.enumeration.pvp.PvpTeam
import com.bselzer.gw2.v2.model.pvp.game.PvpGame
import com.bselzer.ktx.serialization.function.enumValueOrNull
import com.bselzer.ktx.serialization.function.validEnumValues

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