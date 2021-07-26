package com.bselzer.library.gw2.model.extension.common.enumerations.trait

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