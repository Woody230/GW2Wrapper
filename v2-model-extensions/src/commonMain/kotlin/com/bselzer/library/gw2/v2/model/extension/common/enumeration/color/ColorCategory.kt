package com.bselzer.library.gw2.v2.model.extension.common.enumeration.color

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ColorCategory
{
    // Hues
    @SerialName("Gray")
    GRAY,

    @SerialName("Brown")
    BROWN,

    @SerialName("Red")
    RED,

    @SerialName("Orange")
    ORANGE,

    @SerialName("Yellow")
    YELLOW,

    @SerialName("Green")
    GREEN,

    @SerialName("Blue")
    BLUE,

    @SerialName("Purple")
    PURPLE,

    // Materials
    @SerialName("Vibrant")
    VIBRANT,

    @SerialName("Leather")
    LEATHER,

    @SerialName("Metal")
    METAL,

    // Rarities
    @SerialName("Starter")
    STARTER,

    @SerialName("Common")
    COMMON,

    @SerialName("Uncommon")
    UNCOMMON,

    @SerialName("Rare")
    RARE,

    @SerialName("Exclusive")
    EXCLUSIVE
}