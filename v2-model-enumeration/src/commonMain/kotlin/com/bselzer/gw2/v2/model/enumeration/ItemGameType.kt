package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemGameType {
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