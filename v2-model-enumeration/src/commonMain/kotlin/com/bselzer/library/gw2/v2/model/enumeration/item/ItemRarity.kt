package com.bselzer.library.gw2.v2.model.enumeration.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemRarity
{
    @SerialName("Junk")
    JUNK,

    @SerialName("Basic")
    BASIC,

    @SerialName("Fine")
    FINE,

    @SerialName("Masterwork")
    MASTERWORK,

    @SerialName("Rare")
    RARE,

    @SerialName("Exotic")
    EXOTIC,

    @SerialName("Ascended")
    ASCENDED,

    @SerialName("Legendary")
    LEGENDARY;
}