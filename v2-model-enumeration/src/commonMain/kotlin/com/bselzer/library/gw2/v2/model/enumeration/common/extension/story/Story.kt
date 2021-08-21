package com.bselzer.library.gw2.v2.model.enumeration.common.extension.story

import com.bselzer.library.gw2.v2.model.common.story.Story
import com.bselzer.library.gw2.v2.model.enumeration.common.character.RaceName
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [Story.races] as a collection of [RaceName]
 */
fun Story.races(): List<RaceName> = races.validEnumValues()