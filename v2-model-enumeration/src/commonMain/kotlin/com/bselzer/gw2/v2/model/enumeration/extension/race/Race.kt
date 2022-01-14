package com.bselzer.gw2.v2.model.enumeration.extension.race

import com.bselzer.gw2.v2.model.enumeration.character.RaceName
import com.bselzer.gw2.v2.model.race.Race
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [Race.name] as a [RaceName]
 */
fun Race.name(): RaceName? = name.enumValueOrNull<RaceName>()