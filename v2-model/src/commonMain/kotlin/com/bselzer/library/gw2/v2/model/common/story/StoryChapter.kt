package com.bselzer.library.gw2.v2.model.common.story

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoryChapter(
    @SerialName("name")
    val name: String = ""
)