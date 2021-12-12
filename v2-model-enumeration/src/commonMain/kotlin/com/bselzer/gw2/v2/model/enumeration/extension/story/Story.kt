package com.bselzer.gw2.v2.model.enumeration.extension.story

import com.bselzer.gw2.v2.model.enumeration.character.RaceName
import com.bselzer.gw2.v2.model.story.Story
import com.bselzer.ktx.serialization.function.validEnumValues

/**
 * The [Story.races] as a collection of [RaceName]
 */
fun Story.races(): List<RaceName> = races.validEnumValues()