package com.bselzer.library.gw2.v2.model.extension.common.model.pvp

import com.bselzer.library.gw2.v2.model.common.pvp.PvpGame
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.profession.ProfessionName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.pvp.PvpResult
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.pvp.PvpTeam
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

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