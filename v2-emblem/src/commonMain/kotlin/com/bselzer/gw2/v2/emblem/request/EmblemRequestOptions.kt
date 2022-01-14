package com.bselzer.gw2.v2.emblem.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class EmblemRequestOptions {
    @SerialName("BackgroundMaximizeAlpha")
    MAXIMIZE_BACKGROUND_ALPHA,

    @SerialName("ForegroundMaximizeAlpha")
    MAXIMIZE_FOREGROUND_ALPHA
}