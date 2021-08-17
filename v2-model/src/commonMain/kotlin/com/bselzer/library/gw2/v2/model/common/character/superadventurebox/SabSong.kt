package com.bselzer.library.gw2.v2.model.common.character.superadventurebox

import com.bselzer.library.gw2.v2.model.common.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SabSong(
    /**
     * The id of the song.
     */
    @SerialName("id")
    override val id: Int = 0,

    @SerialName("name")
    val name: String = ""
) : Identifiable<Int>