package com.bselzer.library.gw2.v2.model.extension.common.enumeration.scope

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Product
{
    /**
     * The first expansion.
     */
    @SerialName("HeartOfThorns")
    HEART_OF_THORNS,

    /**
     * The second expansion.
     */
    @SerialName("PathOfFire")
    PATH_OF_FIRE,

    /**
     * The third expansion.
     */
    @SerialName("EndOfDragons")
    END_OF_DRAGONS
}