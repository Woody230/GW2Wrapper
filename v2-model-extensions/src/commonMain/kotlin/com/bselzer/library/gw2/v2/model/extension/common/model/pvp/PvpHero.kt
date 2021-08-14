package com.bselzer.library.gw2.v2.model.extension.common.model.pvp

import com.bselzer.library.gw2.v2.model.common.pvp.hero.PvpHero
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.pvp.PvpHeroName
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.pvp.PvpHeroType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [PvpHero.name] as a [PvpHeroName]
 */
fun PvpHero.name(): PvpHeroName? = name.enumValueOrNull<PvpHeroName>()

/**
 * The [PvpHero.type] as a [PvpHeroType]
 */
fun PvpHero.type(): PvpHeroType? = type.enumValueOrNull<PvpHeroType>()