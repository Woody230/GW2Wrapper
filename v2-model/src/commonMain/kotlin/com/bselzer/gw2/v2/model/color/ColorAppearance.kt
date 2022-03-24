package com.bselzer.gw2.v2.model.color

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ColorAppearance(
    @SerialName("brightness")
    val brightness: Int = 0,

    @SerialName("contrast")
    val contrast: Double = 0.0,

    /**
     * The hue in the HSL color space.
     */
    @SerialName("hue")
    val hue: Int = 0,

    /**
     * The saturation in the HSL color space.
     */
    @SerialName("saturation")
    val saturation: Double = 0.0,

    /**
     * The lightness in the HSL color space.
     */
    @SerialName("lightness")
    val lightness: Double = 0.0,

    /**
     * The red, green, and blue values.
     */
    // TODO custom class
    @SerialName("rgb")
    val rgb: List<Int> = emptyList()
)