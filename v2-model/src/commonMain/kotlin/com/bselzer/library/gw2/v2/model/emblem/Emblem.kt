package com.bselzer.library.gw2.v2.model.emblem

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Emblem(
    @SerialName("id")
    override val id: Int = 0,

    /**
     * The URLs representing the components of the emblem.
     */
    @SerialName("layers")
    val layers: List<String> = emptyList()
) : Identifiable<Int>