package com.bselzer.gw2.v2.model.story

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoryChapter(
    @SerialName("name")
    val name: String = ""
)