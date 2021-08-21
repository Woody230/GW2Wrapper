package com.bselzer.library.gw2.v2.model.enumeration.common.trait

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