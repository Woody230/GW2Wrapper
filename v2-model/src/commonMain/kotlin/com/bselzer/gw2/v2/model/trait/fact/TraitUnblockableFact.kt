package com.bselzer.gw2.v2.model.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Unblockable")
data class TraitUnblockableFact(
    /**
     * Whether the effect is unblockable.
     */
    @SerialName("value")
    val value: Boolean = false
) : TraitFact()