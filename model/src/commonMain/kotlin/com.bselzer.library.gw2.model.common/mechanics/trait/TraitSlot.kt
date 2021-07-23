package com.bselzer.library.gw2.model.common.mechanics.trait

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TraitSlot
{
    @SerialName("Major")
    MAJOR,

    @SerialName("Minor")
    MINOR;
}