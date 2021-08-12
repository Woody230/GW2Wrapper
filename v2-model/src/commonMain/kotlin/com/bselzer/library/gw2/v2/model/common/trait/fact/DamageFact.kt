package com.bselzer.library.gw2.v2.model.common.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Damage")
data class DamageFact(
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