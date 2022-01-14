package com.bselzer.gw2.v2.model.enumeration.extension.pvp

import com.bselzer.gw2.v2.model.enumeration.pvp.PvpHeroName
import com.bselzer.gw2.v2.model.enumeration.pvp.PvpHeroType
import com.bselzer.gw2.v2.model.pvp.hero.PvpHero
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [PvpHero.name] as a [PvpHeroName]
 */
fun PvpHero.name(): PvpHeroName? = name.enumValueOrNull<PvpHeroName>()

/**
 * The [PvpHero.type] as a [PvpHeroType]
 */
fun PvpHero.type(): PvpHeroType? = type.enumValueOrNull<PvpHeroType>()