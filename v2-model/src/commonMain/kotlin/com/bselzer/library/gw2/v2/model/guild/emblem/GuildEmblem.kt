package com.bselzer.library.gw2.v2.model.guild.emblem

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildEmblem(
    @SerialName("background")
    val background: GuildEmblemComponent = GuildEmblemComponent(),

    @SerialName("foreground")
    val foreground: GuildEmblemComponent = GuildEmblemComponent(),

    @SerialName("flags")
    val flags: List<String> = emptyList()
)