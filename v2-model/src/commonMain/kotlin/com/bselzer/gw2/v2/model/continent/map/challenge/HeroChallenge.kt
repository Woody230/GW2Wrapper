package com.bselzer.gw2.v2.model.continent.map.challenge

import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeroChallenge(

    @SerialName("id")
    override val id: HeroChallengeId = HeroChallengeId(),

    /**
     * The two-dimensional coordinates within the texture.
     */
    @SerialName("coord")
    val coordinates: List<Double> = emptyList()
) : Identifiable<String>