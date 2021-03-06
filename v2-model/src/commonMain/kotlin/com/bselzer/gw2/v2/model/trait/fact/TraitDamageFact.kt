package com.bselzer.gw2.v2.model.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Damage")
data class TraitDamageFact(
    /**
     * The number of times the damage hits.
     */
    @SerialName("hit_count")
    val hitCount: Int = 0,

    /**
     * The damage multiplier.
     */
    @SerialName("dmg_multiplier")
    val multiplier: Double = 0.0
) : TraitFact()