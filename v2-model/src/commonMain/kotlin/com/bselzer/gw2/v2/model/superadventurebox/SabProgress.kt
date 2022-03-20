package com.bselzer.gw2.v2.model.superadventurebox

import com.bselzer.gw2.v2.model.superadventurebox.song.SabSong
import com.bselzer.gw2.v2.model.superadventurebox.unlock.SabUnlock
import com.bselzer.gw2.v2.model.superadventurebox.zone.SabZone
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