package com.bselzer.library.gw2.v2.model.enumeration.common.achievement

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AchievementType
{
    @SerialName("Default")
    DEFAULT,

    /**
     * A collection of achievements.
     *
     * See [the wiki.](https://wiki.guildwars2.com/wiki/Collections)
     */
    @SerialName("ItemSet")
    ITEM_SET
}