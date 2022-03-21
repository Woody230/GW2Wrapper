package com.bselzer.gw2.v2.model.story.season

import com.bselzer.gw2.v2.model.identifier.StringIdentifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class StorySeasonId(override val value: String = "") : StringIdentifier {
    override fun toString(): String = value
}