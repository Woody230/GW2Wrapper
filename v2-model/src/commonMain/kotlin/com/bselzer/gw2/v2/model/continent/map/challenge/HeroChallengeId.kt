package com.bselzer.gw2.v2.model.continent.map.challenge

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The id of the [HeroChallenge] in the form of a two integers split by a dash.
 * The first number represents the expansion, starting at 0 for the base game.
 */
@Serializable
@JvmInline
value class HeroChallengeId(override val value: String = "") : StringIdentifier