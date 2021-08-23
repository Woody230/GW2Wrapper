package com.bselzer.library.gw2.v2.model.enumeration.extension.story

import com.bselzer.library.gw2.v2.model.enumeration.character.RaceName
import com.bselzer.library.gw2.v2.model.story.Story
import com.bselzer.library.kotlin.extension.serialization.function.validEnumValues

/**
 * The [Story.races] as a collection of [RaceName]
 */
fun Story.races(): List<RaceName> = races.validEnumValues()