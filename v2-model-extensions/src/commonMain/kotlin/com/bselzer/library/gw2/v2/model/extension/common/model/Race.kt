package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.race.Race
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.character.RaceName
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [Race.name] as a [RaceName]
 */
fun Race.name(): RaceName? = name.enumValueOrNull<RaceName>()