package com.bselzer.gw2.v2.emblem.request

import kotlinx.serialization.Serializable

@Serializable
data class EmblemRequest(
    /**
     * The id of the guild to request the emblem for.
     */
    val guildId: String,

    /**
     * The size of the image.
     *
     * The optimal range is between 1 and 128, but the image can be scaled up to 512.
     */
    val size: Int = 1,

    /**
     * The request options.
     */
    val options: Collection<EmblemRequestOptions> = emptyList()
)