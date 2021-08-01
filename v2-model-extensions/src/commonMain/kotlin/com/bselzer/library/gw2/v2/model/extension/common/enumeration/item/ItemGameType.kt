package com.bselzer.library.gw2.v2.model.extension.common.enumeration.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemGameType
{
    @SerialName("Activity")
    ACTIVITY,

    @SerialName("Dungeon")
    DUNGEON,

    @SerialName("Pve")
    PVE,

    @SerialName("Pvp")
    PVP,

    @SerialName("PvpLobby")
    PVP_LOBBY,

    @SerialName("Wvw")
    WVW;
}