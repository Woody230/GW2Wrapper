package com.bselzer.gw2.v2.model.continent.map.adventure

import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Adventure(
    /**
     * The id in the form of a UUID.
     */
    @SerialName("id")
    override val id: AdventureId = AdventureId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    /**
     * The two-dimensional position within the texture.
     */
    @SerialName("coord")
    val coordinates: List<Double> = emptyList()
) : Identifiable<String>