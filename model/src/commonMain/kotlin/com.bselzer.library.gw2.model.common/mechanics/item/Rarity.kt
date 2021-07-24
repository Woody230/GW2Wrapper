package com.bselzer.library.gw2.model.common.mechanics.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Rarity
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