package com.bselzer.library.gw2.v2.model.common.trait.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Unblockable")
data class UnblockableFact(
    /**
     * Whether the effect is unblockable.
     */
    @SerialName("value")
    val value: Boolean = false
) : TraitFact()