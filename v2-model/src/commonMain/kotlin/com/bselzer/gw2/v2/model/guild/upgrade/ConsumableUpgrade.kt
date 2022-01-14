package com.bselzer.gw2.v2.model.guild.upgrade

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The upgrade for banners, guild siege, food, etc.
 */
@Serializable
@SerialName("Consumable")
class ConsumableUpgrade : GuildUpgrade()