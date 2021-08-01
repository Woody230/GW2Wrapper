package com.bselzer.library.gw2.v2.model.extension.common.enumeration.scope

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Access
{
    /**
     * No access.
     */
    @SerialName("None")
    NONE,

    /**
     * A free to play account. The owner has not purchased the game.
     */
    @SerialName("PlayForFree")
    FREE_TO_PLAY,

    /**
     * The base game.
     */
    @SerialName("GuildWars2")
    BASE,

    /**
     * The first expansion.
     */
    @SerialName("HeartOfThorns")
    HEART_OF_THORNS,

    /**
     * The second expansion.
     */
    @SerialName("PathOfFire")
    PATH_OF_FIRE,

    /**
     * The third expansion.
     */
    @SerialName("EndOfDragons")
    END_OF_DRAGONS
}