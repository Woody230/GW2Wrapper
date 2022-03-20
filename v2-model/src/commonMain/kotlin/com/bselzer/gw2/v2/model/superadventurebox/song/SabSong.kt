package com.bselzer.gw2.v2.model.superadventurebox.song

import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SabSong(
    /**
     * The id of the song.
     */
    @SerialName("id")
    override val id: SabSongId = SabSongId(),

    @SerialName("name")
    val name: String = ""
) : Identifiable<Int>