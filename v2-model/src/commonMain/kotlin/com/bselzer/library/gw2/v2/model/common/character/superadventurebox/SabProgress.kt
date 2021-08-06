package com.bselzer.library.gw2.v2.model.common.character.superadventurebox

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SabProgress(
    /**
     * The worlds and difficulties completed.
     */
    @SerialName("zones")
    val zones: List<SabZone> = emptyList(),

    /**
     * The unlocked items.
     */
    @SerialName("unlocks")
    val unlocks: List<SabUnlock> = emptyList(),

    /**
     * The unlocked songs.
     */
    @SerialName("songs")
    val songs: List<SabSong> = emptyList()
)