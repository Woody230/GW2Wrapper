package com.bselzer.library.gw2.v2.model.extension.common.model.story

import com.bselzer.library.gw2.v2.model.common.story.Story
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.character.RaceName
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

/**
 * The [Story.races] as a collection of [RaceName]
 */
fun Story.races(): List<RaceName> = races.validEnumValues()