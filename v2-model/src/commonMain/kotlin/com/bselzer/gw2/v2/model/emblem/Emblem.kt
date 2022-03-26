package com.bselzer.gw2.v2.model.emblem

import com.bselzer.gw2.v2.model.wrapper.Url
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Emblem(
    @SerialName("id")
    override val id: EmblemId = EmblemId(),

    /**
     * The URLs representing the components of the emblem.
     */
    @SerialName("layers")
    val layers: List<Url> = emptyList()
) : Identifiable<Int>