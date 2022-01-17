package com.bselzer.gw2.v2.model.guild.upgrade

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Default")
class DefaultUpgrade(private val identifier: Int = 0) : GuildUpgrade(id = identifier)